package com.sh.study.exercise.nine;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        char[] parr = pattern.toCharArray();
        String[] sarr = s.split(" ");
        if(parr.length != sarr.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for(int i = 0; i < parr.length;i++){
            char key = parr[i];
            String value = sarr[i];
            if(!map.containsKey(key)){
                if(map.containsValue(value)){
                    return false;
                }
                map.put(key,value);
            }else if(!map.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog cat cat fish"));
//        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
