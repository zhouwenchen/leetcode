package com.sh.study.exercise.every.nine;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * @author zhouwenchen
 * @date 2021/9/3 9:47
 **/
public class SmallestK {
    /**
     * 使用小顶堆的呀
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        if(k <= 0){
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for (int value: arr){
            if(priorityQueue.size() < k){
                priorityQueue.add(value);
            }else if(priorityQueue.peek() > value){
                priorityQueue.poll();
                priorityQueue.add(value);
            }
        }

        int i = 0;
        while (!priorityQueue.isEmpty()){
            result[i++] = priorityQueue.poll();
        }
        return result;
    }

    /**
     * 直接排序,取前K个值
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK1(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        Arrays.stream(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)).forEach(System.out::println);
//        Arrays.stream(smallestK1(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)).forEach(System.out::println);
//        Arrays.stream(smallestK(new int[]{1,2,3}, 0)).forEach(System.out::println);
    }
}
