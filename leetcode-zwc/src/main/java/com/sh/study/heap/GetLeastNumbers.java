package com.sh.study.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/19 17:54
 */
public class GetLeastNumbers {
    /**
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if(arr == null || arr.length <= k){
            return arr;
        }
        if(k == 0){
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        for (int value:arr){
            if(queue.size() < k){
                queue.add(value);
            } else if(queue.peek() > value){
                queue.remove();
                queue.add(value);
            }
        }

        for (int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
//        Arrays.stream(getLeastNumbers(new int[]{3, 2, 1}, 2)).forEach(o->System.out.print(o + "\t"));
        Arrays.stream(getLeastNumbers(new int[]{0,0,0,2,0,5}, 0)).forEach(o->System.out.print(o + "\t"));
    }
}
