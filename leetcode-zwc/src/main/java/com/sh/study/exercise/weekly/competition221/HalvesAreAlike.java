package com.sh.study.exercise.weekly.competition221;

/**
 *
 * 5637. 判断字符串的两半是否相似
 *
 * 题目难度Easy
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 *
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * 示例 3：
 *
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "AbCdEfGh"
 * 输出：true
 * @author ：zhouwenchen
 * @date ： 2020/12/27 10:30
 */
public class HalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        if(s == null){
            return false;
        }
        int len = s.length();
        // 转成小写
        String str = s.toLowerCase();
        String first = str.substring(0, len / 2);
        String sencode = str.substring(len / 2 );
        // 遍历
        // 'a'，'e'，'i'，'o'，'u'
        int count1 = 0;
        for (int i = 0; i < first.length();i++){
            if(first.charAt(i) == 'a' || first.charAt(i) == 'e' || first.charAt(i) == 'i'|| first.charAt(i) == 'o'|| first.charAt(i) == 'u'){
                count1++;
            }
        }
        for (int i = 0; i < sencode.length();i++){
            if(sencode.charAt(i) == 'a' || sencode.charAt(i) == 'e' || sencode.charAt(i) == 'i'|| sencode.charAt(i) == 'o'|| sencode.charAt(i) == 'u'){
                count1--;
            }
        }
        if(count1 != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas"));
        System.out.println(halvesAreAlike("AbCdEfGh"));
    }
}
