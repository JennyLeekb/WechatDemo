package com.lkb.annotion.utils;

import com.lkb.annotion.context.HandlerContext;
import com.lkb.annotion.handler.Handler;

import java.util.Map;

/**
 * @Description 工厂类
 * @Author lkb
 * @CreateDate: 2019/5/22
 */
public class BeanFactory {


    private static HandlerContext context;

    public static HandlerContext getContext(){
        return context;
    }

    public static HandlerContext getContext(Map<Integer, Handler> map){
        if(null == context){
            synchronized (BeanFactory.class){
                if(null == context){
                    context = new HandlerContext(map);
                }
            }
        }
        return context;
    }

    public static void registerHandlerContext(HandlerContext handlerContext){
        context = handlerContext;
    }

}
