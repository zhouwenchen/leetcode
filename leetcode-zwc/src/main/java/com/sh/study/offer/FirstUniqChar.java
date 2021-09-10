package com.sh.study.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 * @author zhouwenchen
 * @date 2021/9/10 16:05
 **/
public class FirstUniqChar {

    /**
     * 两次遍历
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // 再次遍历map
        for (int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 优化，如何只遍历一次
     * 如何保证有序性的问题
     *
     * @param s
     * @return
     */
    public static char firstUniqChar1(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] hash = new char[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 存入hash
            hash[arr[i] - 'a']++;
            if(hash[arr[i] - 'a'] == 1){
                map.put(arr[i],i);
            }else {
                map.remove(arr[i]);
            }
        }

        return map.isEmpty()?' ':arr[map.values().iterator().next()];
    }

    public static void main(String[] args) {
//        System.out.println(firstUniqChar("abaccdeff"));
//        System.out.println(firstUniqChar1("abaccdeff"));

        System.out.println(firstUniqChar1("leetcode"));
    }
}
