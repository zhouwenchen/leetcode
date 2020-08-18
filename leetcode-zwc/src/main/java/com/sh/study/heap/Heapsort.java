package com.sh.study.heap;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 堆排序
 *
 * @Author zhouwenchen
 * @Date 2020-08-17 22:47
 */
public class Heapsort {
    /**
     * 数组，从下标 1 开始存储数据
     */
    private int[] values;
    /**
     * 堆中可以存储的最大数据的个数
     */
    private int len;
    /**
     * 堆中已经存储数据的个数
     */
    private int count;

    public Heapsort(int capacity) {
        this.values = new int[capacity + 1];
        this.len = capacity;
        this.count = 0;
    }

    /**
     * 堆插入操作
     *
     * @param data 插入的数据
     */
    public void insertHeapSort(int data) {
        if (count >= len) {
            // 表示堆满了
            return;
        }
        // 插入到最后一个数组的位置
        ++count;
        values[count] = data;
        int i = count;
        // 需要自下而上的堆化操作
        while (i / 2 > 0 && values[i] > values[i / 2]) {
            swap(values, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 数组位置中两个数据的交换操作
     * @param nums 待交换的数据
     * @param i 交换位置 i
     * @param j 待交换位置 j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 删除最大堆
     * 删除堆顶的元素，让堆的最后一个节点替换，然后堆化，使其满足堆的特点
     */
    public void removeHeapMax(){
        if(count == 0){
            return;
        }
        // 堆的最后一个元素替换堆顶元素
        values[1] = values[count];
        --count;
        heapify(values,count,1);
    }

    /**
     * 自上而下的堆化过程
     */
    private void heapify(int[] values, int count, int i) {
        while (true){
            int maxPos = i;
            // 左子节点
            if(i * 2 <= count && values[i] < values[i*2]){
                maxPos = i * 2;
            }
            // 右子节点
            if(i * 2 + 1 <= count && values[maxPos] < values[i*2 + 1]){
                maxPos = i*2+1;
            }
            // 父节点不比左子节点和右子节点大
            if(maxPos == i){
                break;
            }
            swap(values, i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        /**
         * 插入操作
         *
         * 原：0,33,17,21,16,13,15,9,5,6,7,8,1,2,0,0,0,0,0,0,0,
         * 插：0,33,17,22,16,13,15,21,5,6,7,8,1,2,9,0,0,0,0,0,0,
         * 删：
         */
        Heapsort heap = new Heapsort(20);
        AtomicInteger i = new AtomicInteger();
//        int[] nums = new int[]{0, 33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
        int[] nums = new int[]{0, 33, 27, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2,12};
        Arrays.stream(nums).forEach(value -> heap.values[i.getAndIncrement()] = value);
        heap.count = nums.length-1;
        Arrays.stream(heap.values).forEach(o -> System.out.print(o + ","));
        System.out.println();
//        heap.insertHeapSort(22);
        heap.removeHeapMax();
        Arrays.stream(heap.values).forEach(o -> System.out.print(o + ","));


    }
}
