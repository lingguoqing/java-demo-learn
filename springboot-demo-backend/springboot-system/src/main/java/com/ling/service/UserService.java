package com.ling.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ling.common.BaseResponse;
import com.ling.domain.entity.User;
import com.ling.domain.user.ExportPostUser;
import com.ling.domain.user.SelectPostUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 
* @description 针对表【user】的数据库操作Service
* @createDate 2024-10-30 14:00:04
*/
public interface UserService extends IService<User> {

    BaseResponse<Page<User>> selectAllUser(SelectPostUser selectPostUser);

    BaseResponse<String> selectBySex(ExportPostUser exportPostUser, HttpServletRequest request, HttpServletResponse response);

    Page<User> selectByUser(SelectPostUser selectPostUser);
}
