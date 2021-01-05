package com.sh.study.exercise.every;

import java.util.Arrays;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * @author ：zhouwenchen
 * @date ： 2021/1/1 21:09
 */
public class CanPlaceFlowers {
    /**
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 0){
            return false;
        }
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len;i++){
            if(flowerbed[i] == 1){
                count++;
            }
        }
        if( len% 2 == 0){
            // 偶数
            if((count + n) / 2 <= len /2 ){
                return true;
            }
        } else {
            if((count + n) / 2 <= len / 2 + 1){
                return true;
            }
        }
        return false;



//        int count = 0;
//        int m = flowerbed.length;
//        int prev = -1;
//        for (int i = 0; i < m; i++) {
//            if (flowerbed[i] == 1) {
//                if (prev < 0) {
//                    count += i / 2;
//                } else {
//                    count += (i - prev - 2) / 2;
//                }
//                prev = i;
//            }
//        }
//        if (prev < 0) {
//            count += (m + 1) / 2;
//        } else {
//            count += (m - prev - 1) / 2;
//        }
//        return count >= n;

//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode-solution-sojr/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static void main(String[] args) {
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
