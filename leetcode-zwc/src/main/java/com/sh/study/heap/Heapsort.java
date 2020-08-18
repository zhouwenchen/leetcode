package com.sh.study.heap;

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 堆排序的相关操作
 * 1：堆的插入操作
 * 2：堆的堆顶删除操作
 * 3：创建堆
 * 4：堆排序
 *
 * 以下的几个测试案例操作，使用数组存储，但是需要转化成堆，
 * 规则就是某一个节点数组下标为 i，左节点 数组下标  i * 2，右节点 i * 2 + 1,父节点 为  i/2 的下标
 *  原：0,33,17,21,16,13,15,9,5,6,7,8,1,2,0,0,0,0,0,0,0,
 * 插：0,33,17,22,16,13,15,21,5,6,7,8,1,2,9,0,0,0,0,0,0,
 *
 * 原：0,33,27,21,16,13,15,19,5,6,7,8,1,2,12
 * 删：0,27,16,21,12,13,15,19,5,6,7,8,1,2,
 *
 * 原：0, 7, 5, 19, 8, 4, 1, 20, 13, 16
 * 建：0,20,16,19,13,4,1,7,5,8,
 *
 * 原：0,9,6,3,1,5
 * 排序：0,1,3,5,6,9,
 *
 * TODO 将以上数组转化成堆的可视化图操作
 * 扩展：可以阅读 PriorityBlockingQueue 的源码信息
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
     * 堆中已经存储数据的个数,有效的数据
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
     *
     * @param nums 待交换的数据
     * @param i    交换位置 i
     * @param j    待交换位置 j
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
    public void removeHeapMax() {
        if (count == 0) {
            return;
        }
        // 堆的最后一个元素替换堆顶元素
        values[1] = values[count];
        --count;
        heapify(values, count, 1);
    }

    /**
     * 自上而下的堆化过程
     */
    private void heapify(int[] values, int count, int i) {
        while (true) {
            int maxPos = i;
            // 左子节点
            if (i * 2 <= count && values[i] < values[i * 2]) {
                maxPos = i * 2;
            }
            // 右子节点
            if (i * 2 + 1 <= count && values[maxPos] < values[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 父节点不比左子节点和右子节点大
            if (maxPos == i) {
                break;
            }
            swap(values, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 创建堆操作
     *
     * @param values
     * @param n
     */
    public void buildHeap(int[] values, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapifybuild(values, count, i);
        }
    }

    private void heapifybuild(int[] values, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && values[i] < values[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= count && values[maxPos] < values[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(values, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 堆的排序操作
     *
     * @param values
     * @param n
     */
    public void heapSort(int[] values, int n) {
        buildHeap(values, n);
        int k = n;
        while (k > 1) {
            swap(values, 1, k);
            --k;
            heapifybuild(values, k, 1);
        }
    }

    public static void main(String[] args) {
        /**
         * 原：0,33,17,21,16,13,15,9,5,6,7,8,1,2,0,0,0,0,0,0,0,
         * 插：0,33,17,22,16,13,15,21,5,6,7,8,1,2,9,0,0,0,0,0,0,
         *
         * 原：0,33,27,21,16,13,15,19,5,6,7,8,1,2,12
         * 删：0,27,16,21,12,13,15,19,5,6,7,8,1,2,
         *
         * 原：0, 7, 5, 19, 8, 4, 1, 20, 13, 16
         * 建：0,20,16,19,13,4,1,7,5,8,
         *
         * 原：0,9,6,3,1,5
         * 排序：0,1,3,5,6,9,
         */
        Heapsort heap = new Heapsort(20);
        AtomicInteger i = new AtomicInteger();
//        int[] nums = new int[]{0, 33, 17, 21, 16, 13, 15, 9, 5, 6, 7, 8, 1, 2};
//        int[] nums = new int[]{0,33,27,21,16,13,15,19,5,6,7,8,1,2,12};
//        int[] nums = new int[]{0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        int[] nums = new int[]{0, 9, 6, 3, 1, 5};

        Arrays.stream(nums).forEach(value -> heap.values[i.getAndIncrement()] = value);
        heap.count = nums.length - 1;
        Arrays.stream(heap.values).forEach(o -> System.out.print(o + ","));
        System.out.println();
//        heap.insertHeapSort(22);
//        heap.removeHeapMax();
//        heap.buildHeap(nums, heap.count);
        heap.heapSort(nums, heap.count);

//        Arrays.stream(heap.values).limit(heap.count + 1).forEach(o -> System.out.print(o + ","));
        Arrays.stream(nums).limit(heap.count + 1).forEach(o -> System.out.print(o + ","));

    }
}
