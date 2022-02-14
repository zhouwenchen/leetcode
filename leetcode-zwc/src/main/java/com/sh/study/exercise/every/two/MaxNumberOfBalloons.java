package com.sh.study.exercise.every.two;

import java.util.Arrays;

/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 * @author zhouwenchen
 * @date 2022/2/14 11:33
 **/
public class MaxNumberOfBalloons {

    /**
     * 统计计数嘛
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons(String text) {
//        String str = "balloon";
//        int[] arr = new int[26];
//        for (int i = 0; i < str.length()-1; i++){
//            arr[str.charAt(i)-'a'] ++;
//        }
//        int[] textArr = new int[26];
//        for (int i = 0; i < text.length() - 1; i++){
//            textArr[text.charAt(i)-'a']++;
//        }
//        int maxCount = Integer.MAX_VALUE;
//        // 遍历 arr, 取最小值
//        for (int i = 0; i < 26; i++){
//            if(arr[i] == 0){
//                continue;
//            }
//            maxCount = Math.min(textArr[i] / arr[i],maxCount);
//        }
//        return maxCount;

        int[] cnt = new int[5]; // balloon
        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'b'){
                cnt[0]++;
            }else if(ch == 'a'){
                cnt[1]++;
            }else if(ch == 'l'){
                cnt[2]++;
            }else if(ch == 'o'){
                cnt[3]++;
            }else if(ch == 'n'){
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();

    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}
