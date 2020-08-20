package com.sh.study.dynamic;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 * @author zhouwenchen
 * @date 2020-08-20 00:21
 */
public class NthUglyNumber {

    /**
     * 使用一个优先级队列，和一个set集合
     * 优先级队列的队首就是最小值，set用于去重
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        Long[] param = new Long[]{2L,3L,5L};
        for(int i = 0; i < 3; i++){
            heap.add(param[i]);
            set.add(param[i]);
        }

        Long number = Long.valueOf(1);
        for(int i = 1; i < n; i++){
            number = heap.poll();
            for(int j = 0; j < 3; j++){
                long value = param[j] * number;
                if(!set.contains(value)){
                    heap.add(value);
                    set.add(value);
                }
            }
        }
        return number.intValue();
    }

    /**
     * 使用第二种解决方法
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n ; i++){
            int n2 = dp[a] * 2,n3 = dp[b] * 3, n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i] == n2){
                a++;
            }
            if(dp[i] == n3){
                b++;
            }
            if(dp[i] == n5){
                c++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int result = nthUglyNumber1(9);
        System.out.println(result);
    }
}
