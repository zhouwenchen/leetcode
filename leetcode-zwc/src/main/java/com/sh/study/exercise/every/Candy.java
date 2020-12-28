package com.sh.study.exercise.every;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * @Author zhouwenchen
 * @Date
 **/
public class Candy {

    /**
     * TODO 未理解
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0;i < n;i++){
            if(i > 0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 0;
        int ret = 0;
        for (int i = n - 1; i >= 0; i--){
            if(i < n - 1 && ratings[i] > ratings[i+1]){
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i],right);
        }
        return ret;
    }

    /**
     *
     * @param ratings
     * @return
     */
    public static int candy1(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        // 从左边遍历，如果是升序的话，加1
        for (int i = 1; i < ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        int count = left[ratings.length-1];
        // 从右遍历，如果小于的话
        for (int i = ratings.length - 2; i >= 0;i--){
            if(ratings[i] > ratings[i+1]){
                ratings[i] = ratings[i+1] + 1;
            }
            count += Math.max(left[i],right[i]);
        }
        return count + ratings.length;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));

        System.out.println(candy1(new int[]{1,0,2}));
        System.out.println(candy1(new int[]{1,2,2}));
    }
}
