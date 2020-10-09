package com.sh.study.exercise.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Author zhouwenchen
 * @Date  2020-10-09
 **/
public class LengthOfLongestSubstring {
    /**
     * 使用滑动窗口实现操作
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        char[] sarr = s.toCharArray();
        while (right < s.length()){
            // 先右边字符统计
            char c = sarr[right];
            right++;

            // 进行窗口内数据的一系列的更新操作
            map.put(c,map.getOrDefault(c,0) + 1);

            // 判断左侧是否需要收缩操作
            while (map.get(c) > 1){
                char d = sarr[left];
                left++;
                map.put(d,map.get(d)-1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
