package com.sh.study.exercise.weekly.competition215;

import java.util.*;

/**
 * 5603. 确定两个字符串是否接近 显示英文描述
 * 通过的用户数2
 * 尝试过的用户数7
 * 用户总通过次数2
 * 用户总提交次数9
 * 题目难度Medium
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 *
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 *
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 *
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/15 10:34
 */
public class CloseStrings {
    /**
     * 将数据存储到数组中
     * @param word1
     * @param word2
     * @return
     */
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int len = word1.length();
        int[] nums = new int[26];
        for (int i = 0; i < len; i++){
            nums[word1.charAt(i) - 'a']++;
        }
        // 遍历word2
        int[] nums2 = new int[26];
        for (int i = 0; i < len; i++){
            nums2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            // 说明 在第 i 个位置的数据， 一个大于0 一个等于 0
            if (nums[i] + nums2[i] != 0 && nums[i] * nums2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(nums);
        Arrays.sort(nums2);
        // 排序之后，再次判断此位置是否相等
        for (int i = 0; i < 26; i++) {
            if (nums[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String word1 = "abcc";
//        String word2 = "bcac";
//        String word1 = "cabbba";
//        String word2 = "abbccc";
//        String word1 = "";
//        String word2 = "";

        String word1 = "cabbba";
        String word2 = "aabbss";
        /**
         * "cabbba"
         * "abbccc"
         *
         * "cabbba"
         * "aabbss"
         */
        System.out.println(closeStrings(word1, word2));
    }

}
