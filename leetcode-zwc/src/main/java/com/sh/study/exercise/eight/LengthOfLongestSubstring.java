package com.sh.study.exercise.eight;

import java.util.Arrays;
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
     * 感觉像是双指针
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

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     *
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
     * @date 20210421
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        final int n = s == null ? 0: s.length();
        int[] pos = new int[256];
        Arrays.fill(pos,-1);
        int ans = 0;
        int left = -1;
        for (int i = 0; i < n; i++) {
            final int idx = s.charAt(i);
            while (pos[idx] > left){
                left = pos[idx];
            }
            pos[idx] = i;
            ans = Math.max(ans,i - left);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        final int n = s == null ? 0 : s.length();
        int left = -1;
        int result = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < n; i++){
            if(map.containsKey(chars[i])){
                left = Math.max(left,map.get(chars[i]));
            }
            map.put(chars[i],i);
            result = Math.max(result,i - left);
        }
        return result;
    }

    /**
     * 20210428
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        final int n = s == null ? 0: s.length();
        int[] pos = new int[256];
        Arrays.fill(pos,-1);

        int ans = 0;
        int left = -1;
        for (int i = 0; i < n; i++){
            final int idx = s.charAt(i);
            while (pos[idx] > left){
                left = pos[idx];
            }
            pos[idx] = i;
            ans = Math.max(ans,i - left);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring3("abcdeabc"));
    }
}
