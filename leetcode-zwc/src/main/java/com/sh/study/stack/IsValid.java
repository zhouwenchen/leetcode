package com.sh.study.stack;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * @Author zhouwenchen
 * @Data 2020/8/10/17
 **/
public class IsValid {

    private List<Character> right = Arrays.asList(')','}',']') ;
    private List<Character> left = Arrays.asList('(','{','[') ;

    private static Map<Character,Character> leftmap = new HashMap<Character,Character>(){
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };
    private static Map<Character,Character> rightmap = new HashMap<Character,Character>(){
        {
            put(')','(');
            put('}','{');
            put(']','[');
        }
    };
    /**
     *
     * 左括号入栈，右括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            Character temp = new Character(c);

            if (leftmap.containsKey(temp)) {
                stack.push(temp);
            } else if (rightmap.containsKey(temp)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!pop.equals(rightmap.get(temp))) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("()"));
        System.out.println(isValid("["));
    }
}
