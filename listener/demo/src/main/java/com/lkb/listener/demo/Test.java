package com.lkb.listener.demo;

/**
 * @Description 测试
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        DangerEvent dangerEvent = new DangerEvent(child);
        NianShouListener nianShouListener = new NianShouListener();
        TigerListener tigerListener = new TigerListener();
        child.addListener(nianShouListener);
        child.addListener(tigerListener);

        //修改状态
        for(int i=0; i<5; i++){
            if(i == 4){
                dangerEvent.setState(-1);
            }else if(i%2 == 0){
                dangerEvent.setState(1);
            }else{
                dangerEvent.setState(2);
            }
            System.out.println("state: " + dangerEvent.getState());
            child.setEvent(dangerEvent);
            child.notifyDanger();
        }
    }

}




