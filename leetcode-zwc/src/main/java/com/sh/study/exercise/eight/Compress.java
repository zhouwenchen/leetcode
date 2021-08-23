package com.sh.study.exercise.eight;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * <p>
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 * 示例 3：
 * <p>
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 * @author zhouwenchen
 * @date 2021/8/23 14:46
 **/
public class Compress {

    /**
     * 返回的结果是没有问题的，但是数组中的值是不正确的
     *
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) {
            return n;
        }
        int res = 0;
        int tmp = 1;
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty()) {
                Character c = deque.peek();
                if (c == chars[i]) {
                    tmp++;
                    continue;
                } else {
                    if (!deque.isEmpty()) {
                        if(tmp > 1){
                            res++ ;
                        }
                        tmp = 1;
                        deque.pop();
                        deque.push(chars[i]);
                    }
                    res++;
                }
            } else {
                deque.push(chars[i]);
            }
        }
        if(!deque.isEmpty()){
            if(tmp == 1){
                return res + 1;
            }else{
                while (tmp / 10 > 0){
                    res++;
                    tmp /= 10;
                }
                res += 2;
            }
        }
        return res;
    }

    public static int compress1(char[] chars) {
        int n = chars.length;
        int write = 0,left = 0;
        for (int read = 0; read < n; read++){
            if(read == n -1 || chars[read] != chars[read + 1]){
                chars[write++] = chars[read];
                int num = read - left + 1;
                if(num > 1){
                    int anchor = write;
                    while (num > 0){
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;

            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}; //6
//        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}; //6
        char[] chars = new char[]{'a'}; //6
        System.out.println(compress1(chars));
    }
}
