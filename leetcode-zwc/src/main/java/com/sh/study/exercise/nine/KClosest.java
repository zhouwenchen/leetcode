package com.sh.study.exercise.nine;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

/**
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * // TODO 计算每个节点到原点的距离，并存储在数组中，Arrays.sort(arr),再次计算每个节点的平方和是否和 排好序的arr相同，取前 K 个
 * @Author zhouwenchen
 * @Data 2020/10/27/15
 **/
public class KClosest {

    /**
     *
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest(int[][] points, int K) {
        if(points == null){
            return null;
        }
        if(points.length == K){
            return points;
        }

        TreeMap<Integer,int[]> map = new TreeMap<>();
        TreeMap<Integer,int[]> map2 = new TreeMap<>();
        for (int[] point:points){
            int sum = point[0] * point[0] + point[1] * point[1];
            if(!map.containsKey(sum)){
                map.put(sum,point);
            } else{
                // TODO 长度相同的数据如何处理操作
                map2.put(sum, point);
            }
        }
        int[][] result = new int[K][2];
        Set<Integer> keys = map.keySet();
        int index = 0;
        for (Integer key: keys){
            if(index < K){
                result[index++] = map.get(key);
                if(map2.get(key)!=null ){
                    // map2中存在，说明有重复的
                    if(index < K){
                        result[index++] = map2.get(key);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] points = new int[][]{
//                {1,3},
//                {-2,2}
//        };
//        int[][] points = new int[][]{
//                {3,3},
//                {5,-1},
//                {-2,4}
//        };
        int[][] points = new int[][]{
                {1,3},
                {-2,2},
                {2,-2}
        };
        Arrays.stream(kClosest(points, 2)).forEach(o-> Arrays.stream(o).forEach(System.out::println));
    }
}
