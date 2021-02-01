package com.sh.study.exercise.every.two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        int del = (sumA - sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        int[] ans = new int[2];
        for (int y : B){
            int x = y + del;
            if(set.contains(x)){
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})).forEach(System.out::println);
    }
}
