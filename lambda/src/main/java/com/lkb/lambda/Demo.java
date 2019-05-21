package com.lkb.lambda;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;

/**
 * @Description lambda示例
 * @Author lkb
 * @CreateDate: 2019/5/20
 */
public class Demo {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        for(String player : players){
            System.out.print(player + "; ");
        }

        System.out.println();
        players.forEach((String s) -> System.out.print(s + ";"));

        System.out.println();
        players.forEach(System.out::print);
    }
}
