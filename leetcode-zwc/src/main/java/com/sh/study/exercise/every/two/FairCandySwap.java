package com.sh.study.exercise.every.two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * @Author zhouwenchen
 * @Date 2021/2/1 20:44
 **/
public class FairCandySwap {

    /**
     * 求和求平均值
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num: A){
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y: B){
            int x = y + delta;
            if(rec.contains(x)){
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})).forEach(System.out::println);
    }
}
