package com.lkb.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description lambda表达式
 * @Author lkb
 * @CreateDate: 2019/5/20
 */
public class Demo1 {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        List<String> list = Arrays.asList(players);
        list.forEach((String s) -> System.out.print(s + "; "));

        System.out.println("\n使用lambda");

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> comparator = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players,comparator);
        List<String> list1 = Arrays.asList(players);
        list1.forEach((String s) -> System.out.print(s + "; "));

        System.out.println("\n使用lambda2");

        // 1.3 也可以采用如下形式:
        Arrays.sort(players,(String s1, String s2) -> (s1.compareTo(s2)));
        List<String> list2 = Arrays.asList(players);
        list2.forEach((String s) -> System.out.print(s + "; "));

    }


}
