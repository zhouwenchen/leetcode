package com.sh.study.exercise.every.one;

/**
 * 1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 *
 * 提示：
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * @author zhouwenchen
 * @date 2022/1/26 15:26
 **/
public class DayOfTheWeek {
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days =  365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++){
            days += monthDays[i];
        }
        if((year % 400 ==0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3){
            days += 1;
        }
        // 输入月份中的天数贡献
        days += day;
        return week[(days + 3) % 7];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019)); // Saturday
        System.out.println(dayOfTheWeek(18, 7, 1999)); // Sunday
        System.out.println(dayOfTheWeek(15, 8, 1993)); // Sunday
    }
}
