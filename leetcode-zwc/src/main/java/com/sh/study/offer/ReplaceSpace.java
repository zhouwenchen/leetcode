package com.sh.study.offer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author zhouwenchen
 * @date 2021/9/8 10:45
 **/
public class ReplaceSpace {
    /**
     * 这种方式索然无味
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    /**
     * 使用字符替换的方式实现
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {
        char[] charNew = new char[s.length() * 3];
        char[] charOld = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < charOld.length; i++){
            if(charOld[i] == ' '){
                charNew[cur++] = '%';
                charNew[cur++] = '2';
                charNew[cur++] = '0';
            }else {
                charNew[cur++] = charOld[i];
            }
        }

        return new String(charNew,0,cur);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println(replaceSpace1("We are happy."));
    }
}
