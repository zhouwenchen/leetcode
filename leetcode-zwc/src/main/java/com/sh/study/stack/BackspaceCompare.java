package com.sh.study.stack;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * @Author zhouwenchen
 * @Data 2020/8/10/19
 **/
public class BackspaceCompare {

    private  Stack<String> dataStack1 = new Stack();
    private Stack<String> dataStack2 = new Stack();

    /**
     * 字符串入栈操作，如果遇到 # 的话，就进行出栈操作
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        if(S.equals(T)){
            return true;
        }
        String[] s_data = S.split("");
        String[] t_data = T.split("");

        setdataStack(dataStack1,s_data);
        setdataStack(dataStack2,t_data);
        if(dataStack1.equals(dataStack2)){
            return true;
        }
        return false;
    }

    private void setdataStack(Stack<String> dataStack ,String[] s_data) {
        for(String s : s_data){
            if("#".equals(s)){
                if(dataStack.isEmpty()){
                    continue;
                }
                dataStack.pop();
            } else {
                dataStack.push(s);
            }
        }
    }

    /**
     * 优化操作
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare1(String S, String T) {
        return  build(S).equals(build(T));
    }

    private String build(String t) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: t.toCharArray()){
            if('#' != c){
                stack.push(c);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
//        String S = "ab#c",T = "ad#c";
//        String S = "ab##", T = "c#d#";
//        String S = "a##c", T = "#a#c";
        String S = "a#c", T = "b";
        boolean b = new BackspaceCompare().backspaceCompare1(S, T);
        System.out.println(b);
    }
}
