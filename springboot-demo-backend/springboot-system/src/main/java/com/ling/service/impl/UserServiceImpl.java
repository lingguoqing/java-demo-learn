package com.ling.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ling.common.BaseResponse;
import com.ling.common.ResultResponse;
import com.ling.domain.entity.User;
import com.ling.domain.user.ExportPostUser;
import com.ling.domain.user.SelectPostUser;
import com.ling.domain.vo.ExportUserVo;
import com.ling.mapper.UserMapper;
import com.ling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-10-30 14:00:04
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${excel-export.templateFilePath}")
    private String templateFilePath;


    @Override
    public BaseResponse<Page<User>> selectAllUser(SelectPostUser selectPostUser) {
        log.info(selectPostUser.toString());
        Page<User> userPage = new Page<>(selectPostUser.getPageNum(), selectPostUser.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (selectPostUser.getSex() != null) {
            wrapper.eq("sex", selectPostUser.getSex());
        }
        if (selectPostUser.getUsername() != null) {
            wrapper.eq("username", selectPostUser.getUsername());
        }
        return ResultResponse.success(this.baseMapper.selectPage(userPage, wrapper));
    }


    @Override
    public BaseResponse<String> selectBySex(ExportPostUser exportPostUser, HttpServletRequest request, HttpServletResponse response) {

        // 模板文件路径
        String templateFilePath = "E:\\java-demo-learn\\springboot-learn-backend\\file\\test.xlsx";

        // 导出文件路径
        String exportFilePath = "E:\\java-demo-learn\\springboot-learn-backend\\file\\export.xlsx";

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (exportPostUser.getSex() != null) {
            wrapper.eq("sex", exportPostUser.getSex());
        }
        if (exportPostUser.getPhone() != null) {
            wrapper.like("phone", exportPostUser.getPhone());
        }
        List<User> users = this.baseMapper.selectList(wrapper);
        List<ExportUserVo> exportUserVoList = users.stream().map(item -> {
            ExportUserVo exportUserVo = new ExportUserVo();
            BeanUtils.copyProperties(item, exportUserVo);
            // Date转字符串
            exportUserVo.setId(String.valueOf(item.getId()));
            exportUserVo.setSex(item.getSex() == 1 ? "男" : "女");
            return exportUserVo;
        }).collect(Collectors.toList());
/*
        if (exportPostUser.getSex() != null) {
            wrapper.like("sex", exportPostUser.getSex());
        }
        List<User> users = this.baseMapper.selectList(wrapper);
        List<ExportUserVo> exportUserVoList = users.stream().map(item -> {
            ExportUserVo exportUserVo = new ExportUserVo();
            BeanUtils.copyProperties(item, exportUserVo);
            // Date转字符串
            exportUserVo.setId(String.valueOf(item.getId()));
            exportUserVo.setSex(item.getSex() == 1 ? "男" : "女");
            return exportUserVo;
        }).collect(Collectors.toList());
        try {
            ExcelUtils.setExcelResponseProp(request, response, "用户信息");
            OutputStream outputStream = response.getOutputStream();
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write(outputStream, ExportUserVo.class)  // 对应实体类
                    .sheet("用户数据")  // sheet页名称
                    .doWrite(exportUserVoList); // 导出的数据集合
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

/*        boolean hasNext = true;
        try {
            ExcelUtils.setExcelResponseProp(request, response, "用户信息");
            OutputStream outputStream = response.getOutputStream();

            // 分页查询并导出
            int pageSize = 1000; // 每页查询1000条数据
            int currentPage = 1;
            Page<User> page;

            while (hasNext) {
                log.info("==============");
                page = new Page<>(currentPage, pageSize);
                List<User> users = baseMapper.selectPage(page, wrapper).getRecords();
                if (users.isEmpty()) {
                    hasNext = false;
                } else {
                    List<ExportUserVo> exportUserVoList = users.stream().map(item -> {
                        ExportUserVo exportUserVo = new ExportUserVo();
                        BeanUtils.copyProperties(item, exportUserVo);
                        // Date转字符串
                        exportUserVo.setId(String.valueOf(item.getId()));
                        exportUserVo.setSex(item.getSex() == 1 ? "男" : "女");
                        return exportUserVo;
                    }).collect(Collectors.toList());
                    EasyExcel.write(outputStream, ExportUserVo.class)
                            .sheet("用户数据")
                            .doWrite(exportUserVoList);
                }
                currentPage = currentPage + pageSize;
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!hasNext) {
            // 获取输出流名称
            return ResultResponse.success("导出成功");
        } else {
            return ResultResponse.success("导出失败");
        }*/

        // 根据模板导出
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(exportFilePath)
                    .withTemplate(FileUtil.file(templateFilePath))
                    .build();

            WriteSheet writeSheet = EasyExcel.writerSheet().build();

            // 替换模板中的数据
            excelWriter.fill(exportUserVoList, writeSheet);

            // 导出文件
            excelWriter.finish();
        } finally {
            // 关闭writer，释放资源
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
        return null;
    }

    @Override
    public Page<User> selectByUser(SelectPostUser selectPostUser) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(selectPostUser.getPageNum(), selectPostUser.getPageSize());
        if (selectPostUser.getUsername() != null) {
            wrapper.eq("username", selectPostUser.getUsername());
        }
        return this.baseMapper.selectPage(page, wrapper);
    }

}




