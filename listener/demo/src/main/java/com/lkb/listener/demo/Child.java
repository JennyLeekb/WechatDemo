package com.lkb.listener.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 数据源
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class Child {

    private DangerEvent event;
    private List<DangerListener> dangerListeners = new LinkedList<>();

    public DangerEvent getEvent() {
        return event;
    }

    public void setEvent(DangerEvent event) {
        this.event = event;
    }

    public void addListener(DangerListener listener){
        dangerListeners.add(listener);
    }

    public void removeListener(DangerListener listener){
        dangerListeners.remove(listener);
    }

    /**
     * 通知危险
     * @author lkb
     * @date 2019/5/7
     * @param
     * @return void
     */
    public void notifyDanger(){
        if(event.getState() == 1 || event.getState() == 2){
            for(DangerListener dangerListener : dangerListeners){
                dangerListener.handDanger(event);
            }
        }
    }

}
