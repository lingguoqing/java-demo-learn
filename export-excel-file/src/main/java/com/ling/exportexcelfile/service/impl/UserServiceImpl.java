package com.ling.exportexcelfile.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ling.exportexcelfile.domain.entity.User;
import com.ling.exportexcelfile.domain.user.ExportPostUser;
import com.ling.exportexcelfile.domain.vo.ExportUserVo;
import com.ling.exportexcelfile.mapper.UserMapper;
import com.ling.exportexcelfile.service.UserService;
import com.ling.exportexcelfile.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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


    @Override
    public String selectBySex(ExportPostUser exportPostUser, HttpServletRequest request, HttpServletResponse response) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("sex", exportPostUser.getSex());

        List<User> users = this.baseMapper.selectList(wrapper);

        List<ExportUserVo> exportUserVoList = users.stream().map(item -> {
            log.info(item.toString());
            ExportUserVo exportUserVo = new ExportUserVo();
            BeanUtils.copyProperties(item, exportUserVo);
            // Date转字符串
            exportUserVo.setId(String.valueOf(item.getId()));
            return exportUserVo;
        }).collect(Collectors.toList());

        exportUserVoList.forEach(item -> log.info("item:{}", item));
        try {
            ExcelUtils.setExcelResponseProp(request,response, "用户信息");
            OutputStream outputStream = response.getOutputStream();
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write(outputStream, ExportUserVo.class)  // 对应实体类
                    .sheet("用户数据")  // sheet页名称
                    .doWrite(exportUserVoList); // 导出的数据集合
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 获取输出流名称

        return "导出完成";
    }
}




