package com.sh.study.exercise.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * @Author zhouwenchen
 * @Date  2020-09-30
 **/
public class IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if(s != null && t != null && s.length() != t.length()){
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // 需要判断类似 "ab"  "aa" 的情况，在 map中，也就存在  key不同，但是value相同的情况
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < arr1.length; i++){
            if(!map1.containsKey(arr1[i])){
                map1.put(arr1[i],arr2[i]);
            }
            if(!map2.containsKey(arr2[i])){
                map2.put(arr2[i],arr1[i]);
            }
            if(map1.get(arr1[i]) != arr2[i] && map2.get(arr2[i]) != arr1[i]){
                return false;
            }
        }

        if(map1.size() != map2.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "egg";
//        String t = "add";

        String s = "paper";
        String t = "title";

//        String s = "foo";
//        String t = "bar";

//        String s = "ab";
//        String t = "aa";

//        String s = "aa";
//        String t = "ab";

        System.out.println(isIsomorphic(s, t));
    }
}
