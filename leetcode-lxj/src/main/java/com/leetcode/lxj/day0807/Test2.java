package com.leetcode.lxj.day0807;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        /*int[] aar = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(aar));*/
        int[] aar1 = {2, 6, 2, 2, 7};
        System.out.println(maxSumDivThree(aar1));
    }

    public static int maxSumDivThree(int[] nums) {
        List<Integer> div1 = new ArrayList<>();
        List<Integer> div2 = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            if (num % 3 == 1) {
                div1.add(num);
            }
            if (num % 3 == 2) {
                div2.add(num);
            }
            sum += num;
        }
        Collections.sort(div1);
        Collections.sort(div2);
        if (sum % 3 == 0) {
            return sum;
        }
        if (sum % 3 == 1) {
            int result = 0;
            if (!div1.isEmpty()) {
                result = sum - div1.get(0);
            }
            if (div2.size() >= 2) {
                result = Math.max(sum - div2.get(0) - div2.get(1), result);
            }
            return result;
        }
        if (sum % 3 == 2) {
            int result = 0;
            if (!div2.isEmpty()) {
                result = sum - div2.get(0);
            }
            if (div1.size() >= 2) {
                result = Math.max(sum - div1.get(0) - div1.get(1), result);
            }
            return result;
        }
        return 0;
    }

}
