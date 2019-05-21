package com.lkb.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description lambda示例
 * @Author lkb
 * @CreateDate: 2019/5/20
 */
public class Demo3 {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")));
            }
        });
        List<String> list = Arrays.asList(players);
        list.forEach((String s) -> System.out.print(s + ";"));

        System.out.println("\nlambda 表示式1");

        Comparator<String> comparator = (String s1, String s2) ->(s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players,comparator);
        List<String> list2 = Arrays.asList(players);
        list2.forEach((String s) -> System.out.print(s + "; "));
    }
}
