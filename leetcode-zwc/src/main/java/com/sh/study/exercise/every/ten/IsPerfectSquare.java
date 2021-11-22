package com.sh.study.exercise.every.ten;

/**
 *
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 *
 *
 * @author zhouwenchen
 * @date 2021/11/4 16:51
 **/
public class IsPerfectSquare {

    /**
     * 先使用二分法来实现操作
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        int left = 0,right = num;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if(square == num){
                return true;
            }else if(square < num){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(10));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(164));
    }
}
