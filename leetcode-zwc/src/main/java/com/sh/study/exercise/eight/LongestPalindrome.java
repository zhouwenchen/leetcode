package com.sh.study.exercise.eight;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @Author zhouwenchen
 * @Date  2020-10-09
 **/
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        int res = 0;
        for(char t: sarr){
            if(!map.containsKey(t)){
                map.put(t,map.getOrDefault(t,0) + 1);
            }
            if(map.get(t) == 2){
                map.remove(t);
                res+=2;
            }else{
                map.put(t,map.get(t) + 1);
            }
        }
        if(map.size()>=1){
            res +=1;
        }

        return res;
    }

    /**
     * 使用 jdk8 实现基本操作方式
     * @param s
     * @return
     */
    public static int longestPalindrome1(String s) {
        Map<Integer, Integer> map = s.chars().boxed().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int ans  = map.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length()?ans+1:ans;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome1("abccccdd"));
    }
}
