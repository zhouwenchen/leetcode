package com.sh.study.offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * @author zhouwenchen
 * @date 2021/9/26 11:29
 **/
public class MyPow {
    /**
     * TODO 超时了,未完全实现逻辑
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double sum = 1;
        if(x == 1){
            return sum;
        }
        // 判断是否是负数
        boolean isFu = n < 0? true: false;
        n = Math.abs(n);
        for (int i = 0; i < n; i++){
            sum *= x;
        }
        return isFu?1/sum: sum;
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if(x== 0){
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        while (b > 0){
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2.00000, 10));
        System.out.println(myPow1(2.00000, -2));
    }
}
