package com.sh.study.strmatch;

/**
 * RK算法
 *
 * @Author zhouwenchen
 * @Data 2020/8/19/17
 **/
public class RabinKarp {

    /**
     * @param str     主串
     * @param pattern 模式串
     * @return 返回 模式串第一次匹配到主串的位置
     */
    public static int rabinKarp(String str, String pattern) {
        int size1 = str.length();
        int size2 = pattern.length();

        //哈希时需要用到进制计算，这里只涉及26个字母所以使用26进制
        int d = 26;
        //防止hash之后的值超出int范围，对最后的hash值取模
        //q取随机素数，满足q*d < INT_MAX即可
        int q = 144451;
        //str子串的hash值
        int strCode = str.charAt(0) - 'a';
        //pattern的hash值
        int patternCode = pattern.charAt(0) - 'a';
        //d的size2-1次幂，hash计算时，公式中会用到
        int h = 1;
        //计算sCode、pCode、h
        for (int i = 1; i < size2; i++) {
            patternCode = (d * patternCode + pattern.charAt(i) - 'a') % q;
            //计算str第一个子串的hash
            strCode = (d * strCode + str.charAt(i) - 'a') % q;
            h = (h * d) % q;
        }
        //最大需要匹配的次数
        int frequency = size1 - size2 + 1;
        for (int i = 0; i < frequency; i++) {
            if (strCode == patternCode && ensureMatching(i, str, pattern)) {
                return i;
            }
            //更新strCode的值，即计算str[i+1,i+m-1]子串的hashCode
            strCode = ((strCode - h * (str.charAt(i) - 'a')) * d + str.charAt(i + size2) - 'a');
        }
        return 0;
    }

    /**
     * hash值一样并不能完全确保字符串一致，所以还需要进一步确认
     *
     * @param i       hash值相同时字符串比对的位置
     * @param pattern 模式串
     * @return
     */
    private static boolean ensureMatching(int i, String str, String pattern) {
        String strSub = str.substring(i, i + pattern.length());
        return strSub.equals(pattern);
    }

    public static void main(String[] args) {
        String str = "abcabcabc";
        String pattern = "cabc";
        System.out.println("第一次出现的位置:" + rabinKarp(str, pattern));
    }
}
