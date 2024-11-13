package com.ling.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ling.common.BaseResponse;
import com.ling.domain.entity.User;
import com.ling.domain.user.InsertPostUser;
import com.ling.domain.user.SelectPostUser;
import com.ling.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.io.IOException;

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

    @PostMapping("/selectAllUser")
    public BaseResponse<Page<User>> selectAllUser(@RequestBody SelectPostUser selectPostUser) {
        return userService.selectAllUser(selectPostUser);
    }


    @GetMapping(value = "/listDev")
    public SseEmitter list(SelectPostUser selectPostUser) throws IOException {
        System.out.println("======sse技术实现======");
        SseEmitter emitter = new SseEmitter(0L);
        Page<User> user = userService.selectByUser(selectPostUser);
        emitter.send(user);
        // 完成发送
        emitter.complete();
        return emitter;
    }

}
