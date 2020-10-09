package com.sh.study.exercise.eight;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * @Author zhouwenchen
 * @Date  2020-10-09
 **/
public class FindAnagrams {

    /**
     * hash TODO 该方案未解决
     *        String s = "abacbabc";
     *        String p = "abc";      //超时
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        Map<String,Integer> map = new HashMap<>();
        String[] parr = p.split("");
        Arrays.stream(parr).map(o->map.put(o,1));
        Arrays.stream(parr).forEach(o-> {
            if(!map.containsKey(o)) {
                map.put(o,1);
            } else{
                map.put(o,map.get(o)+1);
            }
        });

        List<Integer> result = new ArrayList<>();
        String[] sarr = s.split("");
        int plen = parr.length;
        Map<String,Integer> tempMap = new HashMap<>();
        tempMap.putAll(map);
        int temp = 0;
        for (int i = 0; i < sarr.length;) {
            String key = sarr[i];
            if(!map.containsKey(key)){
                i++;
                temp = i;
                plen = parr.length;
                tempMap.putAll(map);
                continue;
            }
            if(!tempMap.containsKey(key)){
                // 重置计数
                plen = parr.length;
                tempMap.putAll(map);
                if(i - plen + 1 == temp){
                    i = temp+1;
                    temp = i;
                } else {
                    i = Math.max(i - plen + 1,temp);
                }
                continue;
            }
            if(tempMap.get(key) == 1){
                tempMap.remove(sarr[i]);
            } else {
                tempMap.put(key,tempMap.get(key) - 1);
            }
            plen--;
            if(plen == 0 && tempMap.size() == 0){
                result.add(i-parr.length+1);
            }
            i++;
        }
        return result;
    }

    /**
     * TODO
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        // map存储p中出现的字符的数量
        char[] parr = p.toCharArray();
        for(char t: parr){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        char[] sarr = s.toCharArray();
        while (right < s.length()){
            // c 表示要移入的字符
            char c = sarr[right];
            right++;
            // 进行窗口的更新操作
            if(map.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0)+1);
                if(windows.get(c).equals(map.get(c))){
                    valid++;
                }
            }
            // 判断左窗口是否需要收缩
            while (right - left >= p.length()){
                // 在这里更新
               if(valid == map.size()){
                   res.add(left);
               }
                // 左侧移除字符
                char d = sarr[left];
                left++;
                if(map.containsKey(d)){
                    if(map.get(d).equals(windows.get(d))){
                        valid--;
                    }
                    windows.put(d,windows.get(d) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";  // 0 6
//        String s = "abab";
//        String p = "ab";  // 0 1 2
//        String s = "baa";
//        String p = "aa"; // 1

//        String s = "abacbabc";
//        String p = "abc"; // 1 2 3 5
        findAnagrams1(s,p).forEach(System.out::println);
    }
}
