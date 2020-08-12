package com.leetcode.lxj.day0807;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯问题
 */
public class Test {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(45));
        System.out.println("非递归耗时：" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(solution(45));
        System.out.println("递归耗时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 递归，复杂度高，耗费时间长
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        Integer cache = map.get(n);
        if (cache != null) {
            return cache;
        }
        //System.out.println("计算了：" + (n - 1) + "\\+" + (n - 2));
        int result = solution(n - 1) + solution(n - 2);
        map.put(n, result);
        return result;
    }

    /**
     * 非递归
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int pre = 1;
        int next = 1;
        for (int i = 0; i < n - 2; i++) {
            int tmp = pre;
            pre = next;
            next = next + tmp;
        }
        return n < 2 ? 1 : pre + next;
    }
}
