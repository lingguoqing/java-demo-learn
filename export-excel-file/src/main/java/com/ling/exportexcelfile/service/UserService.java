package com.ling.exportexcelfile.service;

import com.ling.exportexcelfile.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ling.exportexcelfile.domain.user.ExportPostUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 
* @description 针对表【user】的数据库操作Service
* @createDate 2024-10-30 14:00:04
*/
public interface UserService extends IService<User> {

    String selectBySex(ExportPostUser exportPostUser, HttpServletRequest request, HttpServletResponse response);
}
