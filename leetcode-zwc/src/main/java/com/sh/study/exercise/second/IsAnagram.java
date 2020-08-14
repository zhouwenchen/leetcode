package com.sh.study.exercise.second;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @Author zhouwenchen
 * @Data 2020/8/14/11
 **/
public class IsAnagram {
    /**
     * 遍历某个元素，如果存在的话，就替换掉第一个为""，最后判断是否为空
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        String[] arr = s.split("");
        for (String str : arr) {
            if (!t.contains(str)) {
                return false;
            }
            t = t.replaceFirst(str, "");
        }
        if (!"".equals(t)) {
            return false;
        }
        return true;
    }

    /**
     * 还有的思路是：
     * 1：先排序，然后比较排序之后的两个字符串是否相等
     * 2：标签：哈希映射
     *      首先判断两个字符串长度是否相等，不相等则直接返回 false
     *      若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     *      s 负责在对应位置增加，t 负责在对应位置减少
     *      如果哈希表的值都为 0，则二者是字母异位词
     *
     */
    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] alpha = new int[26];
        for(int i = 0; i < s.length();i++){
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        // 遍历，判断是否有不等于0的
        for(int i = 0; i < alpha.length;i++){
            if(alpha[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram1(s, t));
    }
}
