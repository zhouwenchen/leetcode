package com.sh.study.exercise.every;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/3 9:30
 */
public class CountPrimes {
    /**
     * 考虑质数的定义：在大于 11 的自然数中，除了 11 和它本身以外不再有其他因数的自然数
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2;i < n;i++){
            ans+=isPrimes(i)?1:0;
        }
        return ans;
    }
    /**
     * 判断是否是质数
     * @param x
     * @return
     */
    private static boolean isPrimes(int x) {
        // 判断从 2，到 x 的开二次根
        for (int i = 2; i * i <=x; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 厄拉多塞筛法
     * TODO 搞不明白
     * @param n
     */
    public static int countPrimes1(int n) {
        int result = 0;
        boolean[] b = new boolean[n];
        if(2 < n){
            result++;
        }

        // 从3开始，只遍历奇数
        for (int i = 3;i < n;i+=2){
            if(!b[i]){
                for (int j = 3; i * j < n; j+=2){
                    b[i*j] = true;
                }
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes1(10));
    }
}
