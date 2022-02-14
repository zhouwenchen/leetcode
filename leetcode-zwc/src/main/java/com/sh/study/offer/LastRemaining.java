package com.sh.study.offer;

/**
 *
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * @author zhouwenchen
 * @date 2021/9/29 11:47
 **/
public class LastRemaining {

    /**
     * 复杂在于计算
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1;++i){
            f = (m + f) % i;
        }
        return f;
    }

    /**
     * 390. 消除游戏
     * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
     *
     * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
     * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
     * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
     * 给你整数 n ，返回 arr 最后剩下的数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 9
     * 输出：6
     * 解释：
     * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
     * arr = [2, 4, 6, 8]
     * arr = [2, 6]
     * arr = [6]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= n <= 109
     * @param n
     * @return
     */
    public static int lastRemaining1(int n) {
        if(n==1) return 1;
        if(n < 6) return 2;
        int start = 1;
        int k = 0,cnt = n,step = 1;
        while (cnt > 1){
            // 偶数
            if(k % 2 == 0){
                start += step;
            }else {
                start = (cnt % 2 == 0) ? start : start + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return start;
    }

    public static int lastRemaining2(int n) {
        if (n == 1) return 1;
        else return 2 * (n / 2 + 1 - lastRemaining2(n / 2));
    }


    public static void main(String[] args) {
//        System.out.println(lastRemaining(5, 3));    // [0,1,2,3,4]
        System.out.println(lastRemaining2(9));    // [0,1,2,3,4]
    }
}
