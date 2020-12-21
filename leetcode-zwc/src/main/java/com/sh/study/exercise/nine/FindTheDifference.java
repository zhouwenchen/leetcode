package com.sh.study.exercise.nine;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class FindTheDifference {
    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        String temp = s+t;
        char[] arr = temp.toCharArray();
        char result = ' ';
        for(char c: arr){
            result ^= c;
        }
        return (char)((char)result + 32);
    }

    /**
     * 基于计数的方式实现
     * @date 20201218
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference1(String s, String t) {
        int[] nums = new int[26];
        for (char s1: s.toCharArray()){
            nums[s1-'a']++;
        }
        for (char t1: t.toCharArray()){
            nums[t1-'a']--;
        }
        //再次遍历，等于-1或者1的
        for (int i = 0; i < 26;i++){
            if(nums[i] == 1 || nums[i] == -1){
                return (char) (i + 'a');
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference1("abcd", "abcde"));
        System.out.println(findTheDifference1("a", "aa"));
        System.out.println(findTheDifference1("ae", "aea"));
        System.out.println(findTheDifference1("", "y"));
        System.out.println(findTheDifference1("", ""));
//        System.out.println('a'^'b');

//        System.out.println(((char)('a'^'b'^'c'^'a'^'b'^'c'^'a')));
        System.out.println((('a'^'a')));

        System.out.println('a' -'a');

    }
}
