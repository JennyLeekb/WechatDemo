package com.lkb.annotion.handler;

import com.lkb.annotion.annotion.HandlerType;
import org.springframework.stereotype.Component;

/**
 * @Description 减操作
 * @Author lkb
 * @CreateDate: 2019/5/22
 */
@HandlerType(2)
@Component
public class SubHandler implements Handler{

    @Override
    public void operate() {
        System.out.println("sub!");
    }
}
