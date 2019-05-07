package com.lkb.listener.demo;

/**
 * @Description 监听器
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class TigerListener implements DangerListener {
    @Override
    public void handDanger(DangerEvent event) {
        if(event.getState() == 2){
            System.out.println("老虎来了，呼叫武松！");
            event.setState(0);
        }
    }
}
