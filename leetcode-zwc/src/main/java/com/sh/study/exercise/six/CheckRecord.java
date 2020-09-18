package com.sh.study.exercise.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 *
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 *
 * 输入: "PPALLL"
 * 输出: False
 *
 * @Author zhouwenchen
 * @Date  2020-09-18
 **/
public class CheckRecord {

    /**
     *
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        if(s == null || s.length() ==0){
            return true;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',1);
        map.put('L',2);

        char A = 'A';
        char L = 'L';

        for(int i = 0; i < chars.length;i++){
            char c = chars[i];
            // A 不超过 1 个
            if(map.get(A) < 0 || map.get(L) < 0){
                return false;
            }
            if(c == A){
                map.put(A,map.get(A) - 1);
            }

            if(c == L){
                map.put(L,map.get(L) - 1);
            } else {
                map.put(L,2);
            }
        }
        // A 不超过 1 个
        if(map.get(A) < 0 || map.get(L) < 0){
            return false;
        }
        return true;
    }

    /**
     * 比较优秀的方法
     *
     * @param s
     * @return
     */
    public static boolean checkRecord1(String s) {
        return !((s.indexOf("A")!=s.lastIndexOf("A"))||(s.indexOf("LLL")!=-1));
    }

    public static void main(String[] args) {
        String s = "AA";
//        String s = "PPALLP";
//        String s = "PPALLL";
        System.out.println(checkRecord1(s));
    }
}