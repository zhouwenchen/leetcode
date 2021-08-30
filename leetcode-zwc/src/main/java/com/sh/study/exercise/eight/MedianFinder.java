package com.sh.study.exercise.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * @author zhouwenchen
 * @date 2021/8/30 10:23
 **/
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;
    public MedianFinder() {
        queMin = new PriorityQueue<>((a,b)->(b-a));
        queMax = new PriorityQueue<>((a,b)->(a-b));
    }

    public void addNum(int num) {
        if(queMin.isEmpty() || num <=queMin.peek()){
            // 添加数据到小顶堆中，此时，如果小顶堆中元素的个数小于小顶堆两个，说明需要将小顶堆的最大值，
            queMin.offer(num);
            if(queMax.size() + 1 < queMin.size()){
                queMax.offer(queMin.poll());
            }
        }else {
            queMax.offer(num);
            if(queMax.size() > queMin.size()){
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if(queMin.size() >queMax.size()){
            return queMin.peek();
        }
        return ((queMin.peek() + queMax.peek()))/2.0;
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
