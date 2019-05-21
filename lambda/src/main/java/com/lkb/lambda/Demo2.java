package com.lkb.lambda;

/**
 * lambda示例
 * @author lkb
 * @date 2019/5/20
 * @param
 * @return
 */
public class Demo2 {

    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("hello world 1!");
           }
       }).start();

       new Thread(()-> System.out.println("hello world 2!")).start();

       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               System.out.println("hello world 3!");
           }
       };

       Runnable runnable1 = () -> System.out.println("hello world 4!");

       new Thread(runnable).start();
       new Thread(runnable1).start();

    }

}
