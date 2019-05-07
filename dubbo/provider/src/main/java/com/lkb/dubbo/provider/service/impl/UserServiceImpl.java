package com.lkb.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lkb.dubbo.api.service.UserService;
import com.lkb.dubbo.api.vo.User;
import org.springframework.stereotype.Component;

/**
 * @Description UserService 实现类
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello(User user) {
        return user.getName() + " say hello! ";
    }
}
