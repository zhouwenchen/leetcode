package com.sh.study.exercise.every.nine;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * @author zhouwenchen
 * @date 2021/9/21 20:45
 **/
public class LengthOfLastWord {

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            deque.push(arr[i]);
        }
        while (!deque.isEmpty()){
            String str = deque.pop();
            if(str.length() > 0){
                return str.length();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
