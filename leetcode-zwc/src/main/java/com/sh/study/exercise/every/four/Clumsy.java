package com.sh.study.exercise.every.four;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 *
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * 示例 2：
 *
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * @author zhouwenchen
 * @date 2021/4/1 9:47
 **/
public class Clumsy {

    private static int result = 0;
    private static int index = 0;
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    private static boolean flag = true;

    public static int clumsy(int N) {
        return  dfs(N);
    }

    /**
     * TODO 没有完成
     * @param n
     * @return
     */
    private static int dfs(int n) {
//        if(n==1){
//            return result;
//        }
       if(index == 0 && flag){
           result = n;
           flag = false;
       } else if(index == 1){
           result = result * n;
       }else if(index == 2){
           result = result / n;
       }else if(index == 3){
           if(stack1.isEmpty()){
               stack1.push(n);
           }else {
               stack1.push(stack1.pop()+n);
           }
       }else{
           if(stack1.isEmpty()){
               stack1.push(result);
               result = n;
           }else {
               stack1.push(stack1.pop() - result);
               result = n;
           }
       }
       if(n == 1){
           return result;
       }
        index = (index + 1 )% 4;
        result = dfs(n - 1);
        return result;
    }


    public static int clumsy1(int N) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(N);
        N--;
        int index = 0;
        while (N > 0){
            if(index % 4 == 0){
                deque.push(deque.pop() * N);
            }else if(index % 4 == 1){
                deque.push(deque.pop() / N);
            }else if(index % 4 == 2){
                deque.push(N);
            }else {
                deque.push(-N);
            }
            index++;
            N--;
        }
        // 将栈中所有的元素出栈求和
        int sum = 0;
        while (!deque.isEmpty()){
            sum += deque.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(clumsy1(4));
        System.out.println(clumsy1(10));
//        System.out.println(4 * 3 / 2 + 1);
        System.out.println(10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1);
    }
}
