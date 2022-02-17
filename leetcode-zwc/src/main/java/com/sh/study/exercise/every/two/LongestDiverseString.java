package com.sh.study.exercise.every.two;

import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 *
 * 提示：
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 * @author zhouwenchen
 * @date 2022/2/15 15:59
 **/
public class LongestDiverseString {
    /**
     * 使用贪心算法
     * 排序，每次从最大的中取出两个，然后拼接一个倒数第二个多的元素
     * TODO 没搞明白
     * */
    public static String longestDiverseString(int a, int b, int c) {
        // 三个元素比较
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o2[1]-o1[1]));
        if (a > 0) maxHeap.add(new int[]{0,a});
        if (b > 0) maxHeap.add(new int[]{1,b});
        if (c > 0) maxHeap.add(new int[]{2,c});
        StringBuilder sb = new StringBuilder();
        int preChar = -1,preCnt = 0;
        while (! maxHeap.isEmpty()){
            int[] node1 = maxHeap.poll(); // 优先使用剩余数量最多的字符
            if (preChar != node1[0] || preCnt < 2) { // 使用该字符不违规
                sb.append((char) ('a' + node1[0]));
                if (node1[1]-- > 1) maxHeap.add(node1);
                preCnt = preChar != node1[0] ? 1 : preCnt+1;
                preChar = node1[0];
            } else { // 使用剩余数量最多的字符违规，则退而求次，使用数量次多的字符
                int[] node2 = maxHeap.poll();
                if (node2 == null) break; // 如果当前只剩1种字符了，没得选了
                maxHeap.add(node1);
                sb.append((char) ('a' + node2[0]));
                if (node2[1]-- > 1) maxHeap.add(node2);
                preCnt = 1;
                preChar = node2[0];
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 2, 7)); // ccaccbcc
    }
}
