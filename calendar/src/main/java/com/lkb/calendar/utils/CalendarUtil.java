package com.lkb.calendar.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 日期工具类
 * @Author lkb
 * @CreateDate: 2019/5/28
 */
public class CalendarUtil {

    public static String PATTERN_DATE = "yyyy-MM-dd";
    public static String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static String PATTERN_MINTIME = "yyyy-MM-dd HH:mm";
    public static String PATTERN_MONTH_DATE = "MM-dd";
    public static String PATTERN_MONTH = "yyyy-MM";

    public static void main(String[] args) {
        Date date = getLastMonthBegin();
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATETIME);
        System.out.println(dateFormat.format(date));
    }

    /**
     * 功能描述: 获取今天
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getToday(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取明天
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getNextDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,+1);
        return calendar.getTime();
    }


    /**
     * 功能描述: 获取昨天
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getBeforeDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取下周今天
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getNextWeekToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH,+1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取上周今天
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getLastWeekToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH,-1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取明年今日
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getNextYearToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,+1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取去年今日
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getLastYearToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,-1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取月初
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getMonthBegin(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }


    /**
     * 功能描述: 获取月末
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getMonthEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        return calendar.getTime();
    }


    /**
     * 功能描述: 获取上月月初
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getLastMonthBegin(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }

    /**
     * 功能描述: 获取上月月末
     * @author lkb
     * @date 2019/5/28
     * @param
     * @return java.lang.String
     */
    public static Date getLastMonthEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        return calendar.getTime();
    }
}
