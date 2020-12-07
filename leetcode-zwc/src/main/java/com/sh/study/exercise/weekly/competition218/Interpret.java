package com.sh.study.exercise.weekly.competition218;

import java.util.Deque;
import java.util.Stack;

/**
 * 5617. 设计 Goal 解析器
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * @author ：zhouwenchen
 * @date ： 2020/12/6 10:30
 */
public class Interpret {

    public static String interpret(String command) {
        if(command == null){
            return command;
        }
        char[] arr = command.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length;i++){
            if('G' == arr[i]){
                sb.append("G");
                continue;
            }
            if('(' == arr[i] || 'a' == arr[i] || 'l' == arr[i]){
                stack.push(arr[i]);
            }
            if(')' == arr[i]){
                if(stack.peek() == 'l'){
                    sb.append("al");
                } else{
                    sb.append("o");
                }
                while (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));// Goal
        System.out.println(interpret("(al)G(al)()()G"));// alGalooG

    }
}
