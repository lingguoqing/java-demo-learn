package com.ling.exportexcelfile.controller;

import com.ling.exportexcelfile.domain.entity.User;
import com.ling.exportexcelfile.domain.user.InsertPostUser;
import com.ling.exportexcelfile.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserContrller {

    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param insertPostUser
     * @return
     */
    @PostMapping("/insert")
    public String insert(@RequestBody InsertPostUser insertPostUser) {
        User user = new User();
        user.setUsername(insertPostUser.getUsername());
        user.setSex(insertPostUser.getSex());
        user.setAddress(insertPostUser.getAddress());
        user.setPhone(insertPostUser.getPhone());
        boolean save = userService.save(user);
        if (save) {
            return "success";
        } else {
            return "error";
        }
    }
}
