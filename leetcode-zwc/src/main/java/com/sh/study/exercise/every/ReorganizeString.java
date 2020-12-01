package com.sh.study.exercise.every;

import com.sun.deploy.util.StringUtils;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/30 9:26
 */
public class ReorganizeString {
    /**
     * 双指针，当遇到第一个相邻重复的元素的时候，从查找相邻重复的元素，如果找不到的话，随便替换一个
     * 以上的思路应该不好操作
     *
     * 思路2：使用计数排序，统计每个元素出现的次数
     *
     * @param s
     * @return
     */
    public static String reorganizeString(String s) {
        // 计数统计
        if(s.length() < 2){
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length;i++){
            counts[s.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount,counts[s.charAt(i)-'a']);
        }
        // 很可能没有重构的字符串
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        // 定义计数坐标和偶数坐标
        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26;i++){
            char c = (char) ('a'+i);
            while (counts[i] > 0 && counts[i] <=halfLength && oddIndex < length){
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex +=2;
            }
            while (counts[i] > 0){
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex +=2;
            }
        }
        return new String(reorganizeArray);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaba"));
    }
}
