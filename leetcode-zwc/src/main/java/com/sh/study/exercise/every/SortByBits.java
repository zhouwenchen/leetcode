package com.sh.study.exercise.every;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * @author ：zhouwenchen
 * @date ： 2020/11/6 11:54
 */
public class SortByBits {
    public static int[] sortByBits(int[] arr) {
        if(arr == null){
            return arr;
        }
        Map<Integer,Integer> map = new HashMap<>();
        // 统计出现的次数
        Map<Integer,Integer> countmap = new HashMap<>();

        for (int value : arr) {
            int key = value;
            if(value == 0){
                map.put(value,0);
                countmap.put(value,1);
                continue;
            }
            int count = 0;
            while (value !=0){
                value &= (value-1);
                count++;
            }
            map.put(key,count);
            countmap.put(key,countmap.getOrDefault(key,0)+1);
        }

        // 根据根据value进行排序，如果value相等的话，根据原始的key进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(((o1, o2) -> {
            if(map.get(o1) != map.get(o2)){
                return map.get(o1) -map.get(o2);
            } else {
                return (Integer) o1 > (Integer) o2 ?1:-1;
            }
        }));
        for (Integer key: map.keySet()){
            for (int i = 0; i < countmap.get(key);i++){
                priorityQueue.add(key);
            }
        }

        // 遍历 priorityQueue 存储到结果数组中
        int[] result = new int[priorityQueue.size()];
        int size = priorityQueue.size();
        for (int i = 0; i < size;i++){
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    /**
     * 使用 数组去统计，
     * @param arr
     * @return
     */
    public static int[] sortByBits1(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int x: arr){
            list.add(x);
            bit[x] = getindex(x);
        }
        // 排序
        Collections.sort(list,(((o1, o2) -> {
            if(bit[o1] != bit[o2]){
                return bit[o1] - bit[o2];
            } else{
               return o1-o2;
            }
        })));

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 更为优秀的操作，基于PriorityQueue实现的操作
     * @param arr
     * @return
     */
    public static int[] sortByBits2(int[] arr) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for (int i = 0; i < arr.length;i++){
            priorityQueue.add(new int[]{arr[i],hammingWeight(i)});
        }
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.poll()[0];
        }

        return arr;
    }

    private static int hammingWeight(int n) {
        int count = 0;
        while (n !=0){
            n &=n-1;
            count++;
        }
        return count;
    }

    /**
     * 计算索引的值
     * @param value
     * @return
     */
    private static int getindex(int value) {
        int count = 0;
        while (value !=0){
            value &= (value-1);
            count++;
        }
        return count;
    }

    public static int[] sortByBits3(int[] arr) {
        int length = arr.length;

        /*
            根据 1的个数 和 当前数值，存储 每一个数字：
                此处是本题解的精髓：1的个数权值最大，其次是本身的值，方便之后的 还原和排序
         */
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }

        /*
            将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序
         */
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }



    public static void main(String[] args) {
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8}; // 0,1,2,4,8,3,5,6,7
//        int[] arr = {10000,10000}; // 0,1,2,4,8,3,5,6,7
        int[] arr = {1046,7811,8129,2277,4129,6370,5456,9743,9660,2735,1119,9232,3469,5173,8217,9903,1213,6005,1202,3947,6711,5781,9169,6004,8359,8957,3605,3606,7531,7514,7832,8722,6062,3220,3586,979,1311,2891,5213,6316,3746,5254,5558,8,8642,5714,8564,1305,320,3586,6950,2574,5658,3061,5312,8773,3426,781,9289,7513,3777,4270,2334,635,8019,1564,4034,8365,4372,298,3667,6566,3777,6136,3031,6091,1737,7894,9648,1112,7303,1255,5754,8203,3826,9390,2022,1140,7804,3521,6361,5867,3100,6045,1964,227,7301,9422,8130,4104,4921,4040,1686,7528,4879,9653,2858,86,3552,8943,3631,8934,1405,8869,4098,1125,5904,9478,6087,3147,3777,8793,2601}; // 0,1,2,4,8,3,5,6,7
        Arrays.stream(sortByBits3(arr)).forEach(o->System.out.print(o +","));
        /**
         * 根据统计的次数
         */
//        System.out.println(6&5);
//        System.out.println(4&3);
    }
}
