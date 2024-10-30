package com.ling.exportexcelfile.controller;

import com.ling.exportexcelfile.domain.user.ExportPostUser;
import com.ling.exportexcelfile.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "导出数据", produces = "application/octet-stream")
    @PostMapping("/export")
    public String export(@RequestBody ExportPostUser exportPostUser, HttpServletRequest request, HttpServletResponse response) {

        return userService.selectBySex(exportPostUser,request, response);
    }
}
