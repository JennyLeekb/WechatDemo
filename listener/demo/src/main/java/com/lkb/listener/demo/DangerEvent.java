package com.lkb.listener.demo;

import java.util.EventObject;

/**
 * @Description 事件
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class DangerEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DangerEvent(Object source) {
        super(source);
    }

    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
