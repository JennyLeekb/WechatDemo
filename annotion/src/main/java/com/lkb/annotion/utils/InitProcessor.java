package com.lkb.annotion.utils;

import com.lkb.annotion.annotion.HandlerType;
import com.lkb.annotion.context.HandlerContext;
import com.lkb.annotion.handler.Handler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 初始化
 * @Author lkb
 * @CreateDate: 2019/5/22
 */
@Component
public class InitProcessor implements BeanPostProcessor {

    private Map<Integer, Handler> map = new HashMap<>(2);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        HandlerType handler =  bean.getClass().getAnnotation(HandlerType.class);
        if(bean instanceof Handler){
            map.put(handler.value(),(Handler)bean);
            HandlerContext context = new HandlerContext(map);
            BeanFactory.registerHandlerContext(context);
        }
        return bean;
    }
}
