package com.sh.study.exercise.three;

import java.net.Inet4Address;
import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * @Author zhouwenchen
 * @Data 2020/8/21/09
 **/
public class TopKFrequent {

    /**
     * 思路1：遍历数组，统计每个元素出现的个数，存入到map集合中key 为值，value为出现的个数，这里需要根据value进行排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        // map value 排序操作
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int[] result = new int[k];
        for(int i = 0; i < result.length;i++){
            Map.Entry<Integer, Integer> integerIntegerEntry = list.get(i);
            result[i] = integerIntegerEntry.getKey();
        }
        return result;
    }

    /**
     * 第一遍遍历 nums，存入数据到map中，key为值，value为出现的次数
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        // 遍历map
        for (Integer key: map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            } else if(map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < result.length;i++){
            while (!priorityQueue.isEmpty()) {
                result[i] = priorityQueue.remove();
            }
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1,o2) ->map.get(o1) - map.get(02));

        for (Integer key: map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            } else if(map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < result.length;i++){
            while (!priorityQueue.isEmpty()) {
                result[i] = priorityQueue.remove();
            }
        }
        return result;
    }

    /**
     * 692. 前K个高频单词
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     *
     * 示例 1：
     *
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     *
     *
     * 示例 2：
     *
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     *     出现次数依次为 4, 3, 2 和 1 次。
     *
     *
     * 注意：
     *
     * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
     * 输入的单词均由小写字母组成。
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent4(String[] words, int k) {
        if(words == null){
            return new ArrayList<>();
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<String> candidates = new ArrayList<>(map.keySet());
        candidates.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        candidates.subList(0, k);
        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{4,1,-1,2,-1,2,3};
//        int[] result = topKFrequent1(nums, 2);
//        int[] result = topKFrequent2(nums, 2);
//        Arrays.stream(result).forEach(System.out::println);

//        List<String> result = topKFrequent4(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        List<String> result = topKFrequent4(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3);
//        List<String> result = topKFrequent4(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        result.stream().forEach(o-> System.out.print(o + "\t"));
//        System.out.println('i'-'l');
    }
}