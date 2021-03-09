package com.sh.study.exercise.every.three;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        if (s == "" && s == null) {
            return "";
        }
        boolean flag = true;
        int index = 0;
        while (flag) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                flag = false;
            }
            index = 0;
        }
        return s;
    }

    /**
     * 使用栈操作
     * abbaca
     * @param s
     * @return
     */
    public static String removeDuplicates2(String s) {
        if(s == null || s == ""){
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peekLast() == c){
                stack.removeLast();
            }else {
                stack.addLast(c);
            }
        }
        // 将栈中的元素出栈
        while (!stack.isEmpty()){
            buffer.append(stack.removeFirst());
        }
        return buffer.toString();
    }

    /**
     * 如果相邻的，有多个都是相同的元素的话，可以一次性将多个元素都替换掉的
     * TODO 以下未实现操作
     *
     * @param s
     * @return
     */
    public static String removeDuplicates1(String s) {
        if (s == "" || s == null) {
            return s;
        }
        boolean flag = true;
        int index = 0;
        while (flag) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    int j = i;
                    while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                        j++;
                    }
                    char tmp = s.charAt(i);
                    s = s.substring(0, i - 1) + s.substring(j + 1);
                    if (j - i > 2 && (j - i) % 2 == 1) {
                        s = tmp + s;
                    }
                    index++;
                }
            }
            if (index == 0) {
                flag = false;
            }
            index = 0;
        }
        return s;
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicates("abbaca"));
//        System.out.println(removeDuplicates("aaaaaaaaabbbbbbcdefghkllmmm")); // acdefghkm
//        System.out.println(removeDuplicates2("aaaaaaaaabbbbbbcdefghkllmmm")); // acdefghkm
        System.out.println(removeDuplicates2("abbaca")); // acdefghkm
        System.out.println(removeDuplicates2("defagagaagdddfffdeeefeafdsafdsafdsajjjjdkallldafeafaeafea")); // defagadfdefeafdsafdsafdsadkaldafeafaeafea
//
//        System.out.println(removeDuplicates1("abbaca"));
//        System.out.println(removeDuplicates1("aaaaaaaaabbbbbbcdefghkllmmm")); // acdefghkm
//        System.out.println(removeDuplicates1("defagagaagdddfffdeeefeafdsafdsafdsajjjjdkallldafeafaeafea")); // defagafdfeafdsafdsafdsadkadafeafaeafea

    }
}
