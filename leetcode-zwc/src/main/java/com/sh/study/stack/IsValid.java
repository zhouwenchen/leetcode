package com.sh.study.stack;

import javax.print.DocFlavor;
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

    /**
     * 使用一个栈实现，遇到左括号 入栈   遇到右括号，出栈操作
     *
     * TODO review
     * @date 2020-10-13
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        if(s == null){
            return false;
        }
        char[] arr = s.toCharArray();
        Map<Character,Character> map = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (char t : arr){
            if(map.containsKey(t)){
                if(stack.isEmpty()){
                    return false;
                }
                if(!map.get(t).equals(stack.peek())){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(t);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 判断字符串括号是否合法
     *
     * 【题目】字符串中只有字符'('和')'。合法字符串需要括号可以配对。比如：
     *
     * 输入："()"
     *
     * 输出：true
     *
     * 解释：()，()()，(())是合法的。)(，()(，(()是非法的。
     *
     * 请你实现一个函数，来判断给定的字符串是否合法。
     * 四部曲：
     * （1）模拟过程
     * （2）规律
     * （3）匹配
     * （4）边界
     *    为空的情况
     *    必须是偶数
     * @date20210302
     *
     * @param s
     */
    public static boolean isValid2(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
               // 准备出栈操作
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 关于以上代码的优化操作
     * 由于入栈操作的都是相同的元素，我们可以仅仅统计入栈元素的个数，而不需要保存具体的栈元素
     *
     * @param s
     * @return
     */
    public static boolean isValid3(String s){
       // 边界元素
       if(s == null || s.length() == 0){
           return true;
       }
       if(s.length() %2 != 0){
           return false;
       }
       int left = 0;
       for (int i = 0; i < s.length();i++){
           char c = s.charAt(i);
           if(c == '('){
               left++;
           }else if(c == ')'){
               if(left == 0){
                   return false;
               }
               left--;
           }
       }
        return left==0;
    }

    public static void main(String[] args) {
//        System.out.println(isValid1("()"));
//        System.out.println(isValid1("{[]}"));
//        System.out.println(isValid1("{[]"));
//        System.out.println(isValid1("["));
//        System.out.println(isValid1("(]"));
//        System.out.println(isValid1("]"));
        System.out.println(isValid3("(())"));
        System.out.println(isValid3("()"));
        System.out.println(isValid3("((()"));
    }
}