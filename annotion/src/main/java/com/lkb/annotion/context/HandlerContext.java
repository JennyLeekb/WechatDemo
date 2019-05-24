package com.lkb.annotion.context;

import com.lkb.annotion.handler.Handler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 上下文
 * @Author lkb
 * @CreateDate: 2019/5/22
 */
public class HandlerContext {

    private Map<Integer, Handler> map = new HashMap<>();

    public HandlerContext(Map<Integer, Handler> map){
        setMap(map);
    }

    public Handler getBean(int type){
        return map.get(type);
    }

    public void setMap(Map<Integer, Handler> map){
        this.map = map;
    }


}
