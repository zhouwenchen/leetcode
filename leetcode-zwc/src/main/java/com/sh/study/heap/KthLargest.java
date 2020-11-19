package com.sh.study.heap;

import java.util.PriorityQueue;

/**
 * @author ：zhouwenchen
 * @date ： 2020/11/19 17:29
 */
public class KthLargest {

    private int k = 0;
    private  PriorityQueue<Integer> queue = new PriorityQueue();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num:nums){
            if(queue.size() <k){
                queue.add(num);
            } else if(num > queue.peek()){
                queue.remove();
                queue.add(num);
            }
        }
    }

    public int add(int val) {
        // 先遍历nums，使用 PriorityQueue ，堆中的数据个数少于k的话，直接存储，
        // 如果数据个数
        if(queue.size() <k){
            queue.add(val);
        } else if(val > queue.peek()){
            queue.remove();
            queue.add(val);
        }
        return !queue.isEmpty()? queue.peek():-1;
    }


    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));// return 4
        System.out.println(kthLargest.add(5));// return 5
        System.out.println(kthLargest.add(10));// return 5
        System.out.println(kthLargest.add(9));// return 8
        System.out.println(kthLargest.add(4));// return 8

    }
}
