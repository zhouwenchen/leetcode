package com.sh.study.heap;

import java.util.PriorityQueue;

/**
 *
 * 假设你正在玩跳跃游戏，从低处往高处跳的时候，可以有两种方法。
 *
 * 方法一：塞砖块，但是你拥有砖块数是有限制的。为了简单起见，高度差就是你需要砖块数。
 *
 * 方法二：用梯子，梯子可以无视高度差（你可以认为再高也能爬上去），但是梯子的个数是有限的(一个只能用一次)。
 *
 * 其他无论是平着跳，还是从高处往低处跳，不需要借助什么就可以完成（在这道题中我们默认无论从多高跳下来，也摔不死）。
 *
 * 给你一个数组，用来表示不同的高度。假设你总是站在 index = 0 的高度开始。那么请问，你最远能跳到哪里?
 *
 * 输入：[3, 1, 6, 20, 10, 20], bricks = 5, landers = 1
 *
 * 输出：4
 *
 */
public class FurthestBuilding {

    /**
     *
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for (int i = 1; i < heights.length ; i++) {
            int deltaH = heights[i] - heights[i-1];
            if(deltaH > 0){
                queue.add(deltaH);
                // 如果优先级队列已经满了，需要拿出一个其中的最小值，改为使用砖块
                if(queue.size() > ladders){
                    sum +=  queue.poll();

                }
                if(sum > bricks){
                    return i-1;
                }
            }
        }
        return n-1;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{3, 1, 6, 20, 10, 20}, 5, 1));
    }
}
