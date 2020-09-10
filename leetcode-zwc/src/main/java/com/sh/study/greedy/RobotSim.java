package com.sh.study.greedy;

import java.util.HashSet;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 *
 *
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * @Author zhouwenchen
 * @Data 2020/9/10/17
 **/
public class RobotSim {

    /**
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public static int robotSim(int[] commands, int[][] obstacles) {
        //direction表当前朝向，0123 表 北东南西
        int ans = 0,direction = 0,x = 0,y = 0;

        //每个朝向上的数据变化，比如朝北时取Direction[0]  ->   {0,1}
        //那么x轴的变化为x+0，y轴变化为y+1;
        int[][] Direction = {{0,1},{1,0},{0,-1},{-1,0}};
        HashSet<String> set = new HashSet<>();
        //将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) {
            set.add(arr[0]+"，"+arr[1]);
        }

        for(int com: commands){
            // 定义下一步的坐标位置
            int next_x = 0;
            int next_y = 0;
            if (com >= 0 ){
                for(int i = 0; i < com; i++){
                    //取得下一步的坐标
                    next_x = x+ Direction[direction][0];
                    next_y = y + Direction[direction][1];
                    // 判断下一步是否有障碍物
                    if(set.contains(next_x+"，"+next_y)){
                        break;
                    }
                    // 否则更新最远距离
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x*x + y * y);
                }
            } else {
                //改变朝向
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] commands = new int[]{4,-1,3};
//        int[][] obstacles = new int[][]{{2,4}};

        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{{2,4}};   // 65

        int robotSim = robotSim(commands, obstacles);
        System.out.println(robotSim);
    }
}
