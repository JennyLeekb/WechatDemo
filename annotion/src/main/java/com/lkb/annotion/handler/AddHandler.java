package com.lkb.annotion.handler;

import com.lkb.annotion.annotion.HandlerType;
import org.springframework.stereotype.Component;

/**
 * @Description 加操作
 * @Author lkb
 * @CreateDate: 2019/5/22
 */
@HandlerType(1)
@Component
public class AddHandler implements Handler {

    @Override
    public void operate() {
        System.out.println("add!");
    }
}
