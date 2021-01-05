package com.sh.study.exercise.every;

import java.util.PriorityQueue;

/**
 * @author ：zhouwenchen
 * @date ： 2021/1/2 22:03
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o1 != o2 ?o1[0]-o2[0]:1);
        return null;
    }

    public static void main(String[] args) {

    }
}
