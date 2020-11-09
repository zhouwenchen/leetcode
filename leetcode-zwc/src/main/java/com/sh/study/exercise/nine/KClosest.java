package com.sh.study.exercise.nine;

import java.util.*;

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

    /**
     * 计算平方和 sum 存储到 arr（可能重复） 中，然后 Arrays.sort(arr) 排序，再次遍历将小于最小的k个目标值找到
     * @param points
     * @param K
     * @date 20201109
     * @return
     */
    public static int[][] kClosest1(int[][] points, int K) {
        // 1. 验证参数的合法性
        if(points == null || points.length == 0){
            return null;
        }

        // 2. 计算平方和存储到 int[] arr 中
//        int[] arr = new int[points.length];
        List<Integer> list = new ArrayList<>(points.length);
        int index = 0;
        for (int[] key: points){
            list.add(key[0] * key[0] + key[1] * key[1]);
        }

        // 排序
        Collections.sort(list);

        // 再次遍历，获取到等于 arr中前K个平方和相等的
        int[][] result = new int[K][2];
        index = 0;

        List<Integer> subList = list.subList(0, K);
        for (int i = 0; i < list.size();i++){
            if (index < K && subList.contains(points[i][0] * points[i][0] + points[i][1]*points[i][01])){
                result[index++] = points[i];
            }
        }

        return result;
    }

    /**
     * IdentityHashMap 可以存储相同的key，判断 key是否相同，根据的内存地址，而不是根据值判断的
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest2(int[][] points, int K) {
        // 1. 验证参数的合法性
        if(points == null || points.length == 0){
            return null;
        }

        // 2. 计算平方和存储到 IdentityHashMap map中，key可以重复，key根据内存地址进行判断是否相等
        Map<String,int[]> map = new IdentityHashMap<>();
        String[] arr  = new String[points.length];
        int index = 0;
        for (int[] value: points){
            int sum = value[0] * value[0] + value[1] * value[1];
            String key = String.valueOf(sum);
            map.put(key,value);
            arr[index++] = key;
        }

        // 排序
        Arrays.sort(arr,0,arr.length,(o1, o2) -> Integer.valueOf(o1)-Integer.valueOf(o2));

        // 再次遍历，获取到等于 arr中前K个平方和相等的
        int[][] result = new int[K][2];
        for (int i = 0; i < K;i++){
            result[i] = map.get(arr[i]);
        }

        return result;
    }

    /**
     * 这种方式更为精彩
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest3(int[][] points, int K) {
        Arrays.sort(points,Comparator.comparingInt(value -> value[0]*value[0]+value[1]*value[1]));
        return Arrays.copyOf(points,K);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,3},
                {-2,2}
        };
//        int[][] points = new int[][]{
//                {3,3},
//                {5,-1},
//                {-2,4}
//        };
//        int[][] points = new int[][]{
//                {1,3},
//                {-2,2},
//                {2,-2}
//        };
        Arrays.stream(kClosest(points, 2)).forEach(o-> Arrays.stream(o).forEach(System.out::println));
        System.out.println("==========");
        Arrays.stream(kClosest2(points, 2)).forEach(o-> Arrays.stream(o).forEach(System.out::println));
        Arrays.stream(kClosest3(points, 2)).forEach(o-> Arrays.stream(o).forEach(System.out::println));


//        HashMap<String,Integer> map = new HashMap<>();
        Map<String,Integer> map = new IdentityHashMap<>();
//        Map<String,Integer> map = new TreeMap<>((o1, o2) -> Integer.valueOf(o1) - Integer.valueOf(o2));
        map.put(new String("1"),2);
        map.put(new String("1"),3);
        map.put(new String("1"),4);
        map.put(new String("1"),5);
        map.put("1",6);
        map.put("1",7);
        map.put("1",8);
        System.out.println(map);

        Arrays.sort(new int[10]);
        Arrays.sort(points,null);


    }
}
