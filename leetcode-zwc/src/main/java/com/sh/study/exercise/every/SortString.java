package com.sh.study.exercise.every;

/**
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/25 9:38
 */
public class SortString {

    /**
     * 使用int[] 存储每个元素出现的次数
     * 然后遍历数据，并记录出现次数最多的元素，说明需要循环的次数
     *
     * @param s
     * @return
     */
    public static String sortString(String s) {
        if(s == null){
            return s;
        }
        // 统计每个元素出现的次数
        int[] nums = new int[26];
        int maxCount = 0;
        for (int i = 0; i < s.length();i++){
            nums[s.charAt(i) - 'a']++;
            int value = nums[s.charAt(i) - 'a'];
            maxCount = Math.max(value,maxCount);
        }
        // 从前往后遍历
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCount;i++){
            // 两个指针，一个从前遍历，一个从后遍历
            int low = 0;
            int hight = 25;
            while (low < 26){
                if(nums[low] > 0){
                    sb.append((char)(low+'a'));
                    nums[low]--;
                }
                low++;
            }
            while (hight >= 0){
                if(nums[hight]> 0 ){
                    sb.append((char)(hight+'a'));
                    nums[hight]--;
                }
                hight--;
            }
        }
        return sb.toString();
    }

    /**
     * 优化，由于每次都是遍历数组26次，我们可以获取到具体统计了多少次
     * 但是效果好像并不明显
     *
     * @param s
     * @return
     */
    public static String sortString1(String s) {
        if(s == null){
            return s;
        }
        // 统计每个元素出现的次数
        int[] nums = new int[26];
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < s.length();i++){
            int index = s.charAt(i) - 'a';
            nums[s.charAt(i) - 'a']++;
            int value = nums[s.charAt(i) - 'a'];
            maxCount = Math.max(value,maxCount);
            maxIndex = Math.max(index,maxIndex);

        }
        // 从前往后遍历
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCount;i++){
            // 两个指针，一个从前遍历，一个从后遍历
            int low = 0;
            int hight = maxIndex;
            while (low < 26){
                if(nums[low] > 0){
                    sb.append((char)(low+'a'));
                    nums[low]--;
                }
                low++;
            }
            while (hight >= 0){
                if(nums[hight]> 0 ){
                    sb.append((char)(hight+'a'));
                    nums[hight]--;
                }
                hight--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortString1("aaaabbbbcccc"));
        System.out.println(sortString1("rat"));
        System.out.println(sortString1("leetcode"));
        System.out.println(sortString1("ggggggg"));
        System.out.println(sortString1("spo"));
//        System.out.println((char)(0+'a'));
    }
}
