package com.sh.study.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 *
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 *
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 * 注意:
 *
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 *
 * @Author zhouwenchen
 * @Data 2020/8/20/17
 **/
public class DistributeCandies {

    /**
     * 思路题解：
     * 如果最大种类数比糖果数的一半小，则妹妹能得到的糖果种类就为最大种类数。
     * 如果最大种类数比糖果数的一半大，即使有这么多类，妹妹也只能得到糖果数的一半。那么此时最多的种类就是她每种拿一个，即个数是糖果总数的一半。
     *
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candie: candies){
            set.add(candie);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        int[] candies = new int[]{1,1,2,2,3,3};
        int cate = distributeCandies(candies);
        System.out.println("有多少种情况存在：\t "+ cate);
    }
}
