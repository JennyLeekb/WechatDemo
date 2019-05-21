package com.lkb.lambda;

import com.lkb.lambda.vo.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description lambda示例
 * @Author lkb
 * @CreateDate: 2019/5/21
 */
public class Demo4 {

    private static final List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    private static final List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };


    public static void main(String[] args) {
        printAll();
//        giveRaise(5);
//        System.out.println("\n加薪后");
//        printAll();
//        System.out.println("\nfilter之后");
//        filter();
//        System.out.println("\nlimit 之后");
//        limit(3);
//        System.out.println("\nlimit 之后");
//        limit(5);
//        System.out.println("\nsort 之后");
//        sort();
//        minAndMax();
//        sum();
        stastics();
    }


    public static void printAll(){
        System.out.println("打印所有程序员的名称");
        javaProgrammers.forEach((Person p) -> System.out.printf("%s %s; ",p.getFirstName(), p.getLastName()));
        System.out.println();
        phpProgrammers.forEach((Person p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    public static void giveRaise(int raise){
        Consumer<Person> consumer = person -> person.setSalary(person.getSalary()/100*raise+person.getSalary());
        javaProgrammers.forEach(consumer);
        phpProgrammers.forEach(consumer);
    }

    public static void filter(){
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        Predicate<Person> salaryFilter = (p) ->(1600 < p.getSalary());

        //查找Java 程序员中年级大于25 并且性别为女性的 并且月薪大于1600
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .filter(salaryFilter)
                .forEach(p->System.out.printf("%s %s %s %d %d; " ,p.getFirstName() ,p.getLastName(), p.getGender(), p.getAge(), p.getSalary()));
    }


    public static void limit(int limit){
        Predicate<Person> genderFilter = (p) -> ("male".equals(p.getGender()));

        //查找php 程序员中为男性  前面limit个
        phpProgrammers.stream()
                .filter(genderFilter)
                .limit(limit)
                .forEach(p -> System.out.printf("%s%s %s; ", p.getFirstName(), p.getLastName(), p.getGender()));
    }

    public static void sort(){
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammer = javaProgrammers.stream()
                .sorted((p1,p2) -> (p1.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(Collectors.toList());
        sortedJavaProgrammer.forEach(p->System.out.printf("%s %s;  ", p.getFirstName(), p.getLastName()));

        System.out.println("\n根据 salary 排序 Java programmers:");
        List<Person> salarySortList = javaProgrammers.stream()
                .sorted((p1,p2) -> (p1.getSalary() - p2.getSalary()))
                .collect(Collectors.toList());
        salarySortList.forEach(p->System.out.printf("%s %s %d;  ", p.getFirstName(), p.getLastName(), p.getSalary()));

    }

    public static void minAndMax(){
        System.out.println("\n获取薪水最少的Java 程序员名称");
        Person person = javaProgrammers.stream()
                .min((p1,p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getSalary());

        System.out.println("\n获取薪水最高的Java 程序员名称");
        Person person1 = javaProgrammers.stream()
                .max((p1,p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(person1.getFirstName() + " " + person1.getLastName() + " " + person1.getSalary());
    }

    public static void sum(){
        System.out.println("\n计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
        System.out.println("total salary is: " + totalSalary);
    }

    public static void stastics(){
        //计算 count, min, max, sum, and average for numbers
        System.out.println("\n");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }


}


