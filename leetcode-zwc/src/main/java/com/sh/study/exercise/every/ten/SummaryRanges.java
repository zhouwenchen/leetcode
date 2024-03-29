package com.sh.study.exercise.every.ten;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * 352. 将数据流变为多个不相交区间
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 *
 * 示例：
 *
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 *
 *
 * 提示：
 *
 * 0 <= val <= 104
 * 最多调用 addNum 和 getIntervals 方法 3 * 104 次
 *
 *
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * @author zhouwenchen
 * @date 2021/10/9 9:33
 *
 **/
public class SummaryRanges {

    /**
     * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/solution/jiang-shu-ju-liu-bian-wei-duo-ge-bu-xian-hm1r/
     *
     */
    TreeMap<Integer, Integer> intervals;
    public SummaryRanges() {
        intervals = new TreeMap<Integer,Integer>();
    }

    public void addNum(int val) {
        // 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
        // 如果不存在这样的区间，interval1 为尾迭代器
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);  // 返回大于或者等于key的第一个元素：
        // 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
        // 在有序集合中，interval0 就是 interval1 的前一个区间
        // 如果不存在这样的区间，interval0 为尾迭代器
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);  // 返回小于等于key的第一个元素：

        if(interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()){
            // 情况一：
            return;
        }else {
            boolean leftAside= interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            if(leftAside && rightAside){
                // 情况四：
                Integer left = interval0.getKey();
                Integer right = interval1.getValue();
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(left,right);
            }else if(leftAside){
                // 情况二：
                intervals.put(interval0.getKey(),interval0.getValue()+1);
            }else if(rightAside){
                // 情况三：
                Integer right = interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(val,right);
            }else {
                // 情况五：
                intervals.put(val,val);
            }
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            Integer left = entry.getKey();
            Integer right = entry.getValue();
            ans[index][0] = left;
            ans[index][1] = right;
            ++index;
        }
        return ans;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        Arrays.stream(summaryRanges.getIntervals()).forEach(o-> Arrays.stream(o).forEach(a->System.out.print(a+"\t"))); // 返回 [[1, 1]]
        System.out.println();
        summaryRanges.addNum(3);      // arr = [1, 3]
        Arrays.stream(summaryRanges.getIntervals()).forEach(o-> Arrays.stream(o).forEach(a->System.out.print(a+"\t")));  // 返回 [[1, 1], [3, 3]]
        System.out.println();
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        Arrays.stream(summaryRanges.getIntervals()).forEach(o-> Arrays.stream(o).forEach(a->System.out.print(a+"\t")));  // 返回 [[1, 1], [3, 3], [7, 7]]
        System.out.println();
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        Arrays.stream(summaryRanges.getIntervals()).forEach(o-> Arrays.stream(o).forEach(a->System.out.print(a+"\t")));  // 返回 [[1, 3], [7, 7]]
        System.out.println();
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        Arrays.stream(summaryRanges.getIntervals()).forEach(o-> Arrays.stream(o).forEach(a->System.out.print(a+"\t")));  // 返回 [[1, 3], [6, 7]]
    }
}
