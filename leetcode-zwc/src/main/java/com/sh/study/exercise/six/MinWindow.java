package com.sh.study.exercise.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 *
 * 提示：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 解题思路
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 *
 *
 * TODO 滑动窗口的解决模板
 * void slidingWindow(string s, string t) {
 *     unordered_map<char, int> need, window;
 *     for (char c : t) need[c]++;
 *
 *     int left = 0, right = 0;
 *     int valid = 0;
 *     while (right < s.size()) {
 *         // c 是将移入窗口的字符
 *         char c = s[right];
 *         // 右移窗口
 *         right++;
 *         // 进行窗口内数据的一系列更新
 *         ...
 *
 *         // debug 输出的位置
 *         printf("window: [%d, %d)\n", left, right);
 *         //
 *
 *         // 判断左侧窗口是否要收缩
 *         while (window needs shrink) {
 *             // d 是将移出窗口的字符
 *             char d = s[left];
 *             // 左移窗口
 *             left++;
 *             // 进行窗口内数据的一系列更新
 *             ...
 *         }
 *     }
 * }
 *
 * @Author zhouwenchen
 * @Date  2020-09-18
 **/
public class MinWindow {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        // 记录需要的字符个数
        int[] need = new int[128];
        for(int i = 0; i < t.length();i++){
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0,r = 0,size = Integer.MAX_VALUE,count = t.length(),start = 0;
        // 遍历所有字符
        while ( r < s.length()){
            char c = s.charAt(r);
            // 需要的字符
            if(need[c] > 0){
                count--;
            }

            need[c]--;//把右边的字符加入窗口
            if(count == 0){
                while (l < r && need[s.charAt(l)] < 0){
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }

                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        char[] tarr = t.toCharArray();
        for(char c: tarr){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        char[] sarr = s.toCharArray();
        while (right < s.length()){
            // c 表示要移入的字符
            char c = sarr[right];
            // 右移窗口
            right++;
            // 进行窗口的一系列的更新操作
            if(map.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0)+1);
                if (windows.get(c).equals(map.get(c))){
                    valid++;
                }
            }

            // 判断左边窗口是否需要右移操作
            while (valid == map.size()){
                // 在这里更新
                if(right  - left < len){
                    start = left;
                    len = right - left;
                }

                // 将字符移除窗口
                char d = sarr[left];
                left++;
                // 进行窗口内的一系列数据更新
                if(map.containsKey(d)){
                    if(map.get(d).equals(windows.get(d))){
                        valid--;
                    }
                    windows.put(d,windows.get(d) - 1);
                }
            }
        }
        return len ==Integer.MAX_VALUE ? "": s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
