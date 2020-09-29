package com.sh.study.exercise.eight;

import java.util.*;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @Author zhouwenchen
 * @Date  2020-09-29
 **/
public class FirstUniqChar {

    /**
     * 遍历两遍 hash
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int loc = 0;
        if(s == null || "".equals(s)){
            return -1;
        }
        char[] hash = new char[26];
        char[] arrs = s.toCharArray();

        for(char arr: arrs){
            hash[arr - 'a'] ++;
        }
        // 再次遍历 arrs，判断 hash中的值是否是1
        for(char arr: arrs){
            if(hash[arr-'a'] == 1){
                return loc;
            }
            loc++;
        }
        return -1;
    }

    /**
     * 思考：如何优化，仅遍历遍历一次hash就可以
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {

        if(s == null || "".equals(s)){
            return -1;
        }
        char[] hash = new char[26];
        char[] arrs = s.toCharArray();
        int loc = 0;
        LinkedList<Integer> loclist = new LinkedList<Integer>();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < arrs.length;i++){
            hash[arrs[i] - 'a'] ++;
            if(hash[arrs[i]-'a'] == 1){
                map.put(arrs[i],i);
            }else{
                map.remove(arrs[i]);
            }
        }

        // 获取map 第一个值的 value
        return map.isEmpty()?-1:map.values().iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("leetcode"));      // 0
        System.out.println(firstUniqChar1("loveleetcode"));  // 2
        System.out.println(firstUniqChar1(""));  // -1
        System.out.println(firstUniqChar1("aabb"));  // -1
        System.out.println(firstUniqChar1("aab"));  // 2
        System.out.println(firstUniqChar1("aab"));  // 2
    }
}
