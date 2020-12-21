package com.sh.study.exercise.every;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/12 20:33
 */
public class ArrangeCoins {
    /**
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        if(n==0){
            return 0;
        }
        if(n ==1 || n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int sum = 0;
        int i = 0;
        for (i = 1; i < n;i++){
            if(sum > n){
                break;
            }
            sum +=i;
        }
        return i-2;
    }

    /**
     * @date 202012181125
     * @param n
     * @return
     */
    public static int arrangeCoins1(int n) {
        if(n==0){
            return 0;
        }
        if(n ==1 || n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int result = 0;
        long sum = 0;
        for (int i = 0; i < n;i++){
            sum += i;
            if(sum > n){
                result = i -1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins1(5));
        System.out.println(arrangeCoins1(8));
        System.out.println(arrangeCoins1(2147483647));
        System.out.println(65535 + 65535 > 65535);
    }
}
