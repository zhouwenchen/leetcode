package com.sh.study.stack;

import java.util.Stack;

/**
 * 例 2：大鱼吃小鱼
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 *
 * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 *
 * 当方向相对时，大鱼会吃掉小鱼；
 *
 * 鱼的大小都不一样。
 *
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 */
public class FishCount {

    /**
     *（1）模拟过程
     *
     *（2）规律
     * 相对的方向，大鱼吃小鱼
     *（3）匹配
     *（4）边界
     * 没有鱼，
     * 只有一条鱼
     *
     * @param fishSize
     * @param fishDirection
     * @return
     */
    public static int fishCount(int[] fishSize, int[] fishDirection){
        // 首先拿到鱼的数量
        int fishNumber = fishSize.length;
        if(fishNumber <= 1){
            return fishNumber;
        }

        // 0 表示鱼向左游
        int left = 0;
        int right = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < fishNumber;i++){
            // 当前鱼的情况，大小和方向
            int curFishSize = fishSize[i];
            int curFishDir = fishDirection[i];

            // 当前的鱼是否被栈中的鱼吃掉呢
            boolean hasEat = false;
            // 如果当前栈不为空，并且栈中鱼向右，当前向左，那么就有相遇的可能性
            while (!stack.isEmpty() && fishDirection[stack.peek()] == right && curFishDir == left ){
                // 如果栈顶的元素比较大，新来的元素就吃掉了
                if(fishSize[stack.peek()] >=curFishSize){
                    hasEat = true;
                    break;
                }
                // 如果栈顶的元素比较小，那么新来的元素就会把她吃掉的
                stack.pop();
            }
            // 如果新来的鱼没有没吃掉，就压入栈中
            if(!hasEat){
                stack.push(i);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        int[] size = new int[]{4, 2, 5, 3, 1};
        int[] dir = new int[]{1, 1, 0, 0, 0};
        System.out.println(fishCount(size, dir));
    }
}
