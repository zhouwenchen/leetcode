package com.sh.study.greedy;

import java.util.*;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @Author zhouwenchen
 * @Data 2020/8/20/19
 **/
public class EraseOverlapIntervals {

    /**
     * 1:数组中 左值排序
     * 2：比较：如果左值相同，就去掉右值较大的数据
     * 3：如果下一个元素的左值比上一个右值都大，不做处理，如果小于的话，就删除
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {

        // map 中存储，key存储数组最小值，value 存储数组，如果key有重复的话，那么就需要删除+1
        int deletecount = 0;
        Map<Integer, int[]> map  = new TreeMap<Integer,int[]>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int oldMinValue = Integer.MAX_VALUE;
//        for(int i = 0; i < intervals.length;i++){
//            int key = intervals[i][0];
//            // 如果左值相同，就去掉一个右值的最大值。
//            if(map.containsKey(key)){
//                oldMinValue = Math.min(intervals[i][1],oldMinValue);
//                intervals[i][1] = oldMinValue;
//                map.put(key,intervals[i]);
//                deletecount++;
//            } else if(oldMinValue > intervals[i][0] || oldMinValue < intervals[i][1]){
//                // 左值小于上一个的最右值,直接去掉当前值
//                deletecount++;
//                oldMinValue = Math.min(Math.min(intervals[i][1],oldMinValue),intervals[i][0]);
//            }else {
//                map.put(key,intervals[i]);
//                oldMinValue =intervals[i][1];
//            }
//        }
        // 遍历操作

        return deletecount;
    }

    public static int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        // 排序
        Arrays.sort(intervals,(o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        int n = intervals.length;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        for (int i = 1;i < n;++i){
            for (int j = 0;j < i;++j){
                if(intervals[j][1] <= intervals[i][0]){
                    arr[i] = Math.max(arr[i],arr[j]+1);
                }
            }
        }
        return n - Arrays.stream(arr).max().getAsInt();
    }

    /**
     * 20210507 根据end 进行排序
     *
     * @param intervals
     * @return
     */
    public static int nonOverlapIntervals(int[][] intervals){
        final int len = intervals == null ? 0 : intervals.length;

        // 排序
        Arrays.sort(intervals,(o1, o2) -> o1[1]==o2[1]?0:(o1[1]<o2[1]?-1:1));

        // 已经重叠的最后段
        int maxEnd = Integer.MIN_VALUE;
        int ans = 0;
        // 开始贪心算法
        for (int i = 0; i < len; i++) {
            if(maxEnd <= intervals[i][0]){
                maxEnd = intervals[i][1];
                ans++;
            }
        }
        return len - ans;
    }

    /**
     * 20210507 根据start 进行排序,从后面进行处理遍历操作
     * @param intervals
     * @return
     */
    public static int nonOverlapIntervals1(int[][] intervals){
        final int len = intervals == null?0: intervals.length;
        // 排序
        Arrays.sort(intervals,(o1, o2) -> o1[0]==o2[0]?0:(o1[0] < o2[0]?-1:1));
        int ans = 0;
        int minStart = Integer.MAX_VALUE;
        // 从后往前进行处理操作
        for (int i = len - 1; i >= 0; i--) {
            if(minStart >= intervals[i][1]){
                minStart = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,2}, {2,3}};
//        int[][] intervals = new int[][]{ {1,2}, {2,3}, {3,4}, {1,3} };
//        int[][] intervals = new int[][]{ {1,2}, {1,2}, {1,2}, {1,2} };
        int[][] intervals = new int[][]{{1,100},{11,22},{1,11},{2,12} };
//        int min = eraseOverlapIntervals(intervals);
//        System.out.println(min);

//        System.out.println(eraseOverlapIntervals1(intervals));
//        System.out.println(nonOverlapIntervals(intervals));
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
