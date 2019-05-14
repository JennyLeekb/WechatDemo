package com.lkb.validation.controller;

import com.lkb.validation.vo.Result;
import com.lkb.validation.vo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description 用户管理
 * @Author lkb
 * @CreateDate: 2019/5/14
 */
@RestController
@Validated
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/add")
    public Result addUser(@RequestBody @Validated User user){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("新增成功");
        result.setData(user);
        return result;
    }


    @RequestMapping("/setName")
    public Result setName(@NotNull(message = "name 为空") @Size(max = 5, message = "name 长度大于5") String name){
        User user = new User();
        user.setName(name);
        Result result = new Result();
        result.setCode(1);
        result.setMessage("新增成功");
        result.setData(user);
        return result;
    }

}
