package com.sh.study.exercise.every.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：[]
 *
 *
 * @author zhouwenchen
 * @date 2022/2/14 13:59
 **/
public class SimplifiedFractions {

    /**
     * 先不考虑简化的
     * @param n
     * @return
     */
    public static List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++){
                // 如何判断 i 和 j的最大公约数
                if(gcd(i,j) == 1){
                    String str = i+"/"+j;
                    result.add(str);
                }
            }
        }
        return result;
    }

    /**
     * 判断是否是最小值
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        simplifiedFractions(4).stream().forEach(System.out::println);
    }
}
