package com.lkb.listener.demo;

import java.util.EventListener;

/**
 * 监听器
 * @author lkb
 * @date 2019/5/7
 * @param
 * @return
 */
public interface DangerListener extends EventListener {
    void handDanger(DangerEvent event);
}
