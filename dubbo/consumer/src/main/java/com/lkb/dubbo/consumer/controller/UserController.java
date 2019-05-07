package com.lkb.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lkb.dubbo.api.service.UserService;
import com.lkb.dubbo.api.vo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户管理
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;

    @PostMapping("/say")
    public String sayHello(@RequestParam String name){
        User user = new User();
        user.setName(name);
        return userService.sayHello(user);
    }

}
