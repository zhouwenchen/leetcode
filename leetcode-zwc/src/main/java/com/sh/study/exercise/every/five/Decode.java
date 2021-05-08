package com.sh.study.exercise.every.five;

import java.util.Arrays;

/**
 * 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 *
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *
 *
 * 提示：
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 *
 * @author zhouwenchen
 * @date 2021/5/6 9:57
 **/
public class Decode {

    public static int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] result = new int[len + 1];
        result[0] = first;
        for (int i = 0; i < len;i++){
            int tmp = encoded[i] ^ first;
            result[i+1] = tmp;
            first = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(decode(new int[]{1,2,3}, 1)).forEach(o-> System.out.println(o));
//        System.out.println(1^0); // 1
//        System.out.println(0^2); // 2
//        System.out.println(2^1); // 3
//
//        System.out.println("===========");
//        System.out.println(1^1);
//        System.out.println(0^2);
//        System.out.println(2^3);
    }
}
