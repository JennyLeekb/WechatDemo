package com.lkb.listener.demo;

import java.util.EventListener;

/**
 * @Description 监听器
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class NianShouListener implements DangerListener{
    @Override
    public void handDanger(DangerEvent event) {
        if(event.getState() == 1){
            System.out.println("年兽来了，呼唤爆竹！");
            event.setState(0);
        }
    }
}
