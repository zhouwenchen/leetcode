package com.sh.study.exercise.every.nine;

import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 *
 *
 * 提示:
 *
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 *
 * @author zhouwenchen
 * @date 2021/9/5 16:12
 **/
public class Rand10 extends SolBase {

    public static int rand10() {
        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();
        // 只要它还大于10，那就给我不断生成，因为我只要范围在1-10的，最后直接返回就可以了
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(rand10());

    }
}

class SolBase {

    public static int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }

}
