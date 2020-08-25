package com.sh.study.dynamic;

/**
 * 0-1背包问题
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
 * 在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 *
 * @author zhouwenchen
 * @date 2020-80-22 15:30
 */
public class BagPromble {

    /**
     * i 表示将要决策第几个物品是否装入背包，cw 表示当前背包中物品的总重量
     */
    private static int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private static int[] weight = new int[]{2,2,4,6,3};  // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    /**
     * 优化操作：由于在操作过程中，存在重复的操作，所以添加一个备忘录的数组
     * TODO 这一题没有测试明白。。。。。。
     */
    private static boolean[][] mem = new boolean[5][10];

    public static void bagPromble(int i, int cw) {
        //  cw==w 表示装满了，i==n 表示物品都考察完了
        if(cw == w|| i == n){
            if(cw > maxW){
                maxW = cw;
            }
            return;
        }

        // 重复的元素直接
        if(mem[i][cw]){
            return;
        }
        mem[i][cw] = true;
        // 表示第 i 个背包不装
        bagPromble(i+1,cw);
        if(cw + weight[i] <= w){
            bagPromble(i+1,cw + weight[i]);
        }
        return;
    }


    /**
     * 以下使用动态规划实现操作
     */
//    weight: 物品重量，n: 物品个数，w: 背包可承载重量
    public static int knapsack(int[] weight,int n,int w){
        // 默认值是false
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true; // 第一行的数据需要特殊处理，作为哨兵处理
        states[0][weight[0]] = true;
        // 动态规划状态转移操作
        for (int i = 1; i < n; i++) {

            // 复制上一次是true的情况
            for(int j = 0; j <= w;++j){
                if(states[i-1][j] == true){
                    states[i][j] = states[i-1][j];
                }
            }

            for(int j = 0;j <= w - weight[i] ;++j){
                if(states[i-1][j] == true){
                    states[i][j+weight[i]] = true; // 由于条件中判断中    j <= w -weight[i]; ==> j + weight[i] <= w,也就不会数组下标越界操作
                }
            }
        }
        // 输出结果，输出最后一个值为 true的值
        for (int i = w ; i>= 0;--i){
            if(states[n-1][i] == true){
                return i;
            }
        }
        return 0;
    }

    /**
     * 优化以上的操作，仅用一维数据就可以实现操作
     * items: 物品重量，n: 物品个数，w: 背包可承载重量
     *
     * 这边优化的思路和上一个比较，不同来自于
     *
     * @return
     */
    public static int knapsack2(int[] items,int n,int w){
        boolean[] status = new boolean[w+1];
        // 第一行特殊处理，作为哨兵
        status[0] = true;
        status[items[0]] = true;
        for(int i = 1; i< n;++i){
            for(int j = w-weight[i];j >= 0; --j){
                if(status[j]){
                    status[j+items[i]] = true;
                }
            }
        }
        for(int i = w; i>= 0; --i){
            if(status[i]){
                return i;
            }
        }
        return 0;
    }

    /**
     * TODO 背包问题升级操作
     * 重量和物品重量。我们现在引入物品价值这一变量
     * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢
     * @param args
     */
    private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
    private int[] items = {2,2,4,6,3};  // 物品的重量
    private int[] value = {3,4,8,9,6}; // 物品的价值
//    private int n = 5; // 物品个数
//    private int w = 9; // 背包承受的最大重量
    public void f2(int i, int cw, int cv) { // 调用 f(0, 0, 0)
        if(cw == w || i == n){ // cw==w 表示装满了，i==n 表示物品都考察完了
            if(cv > maxV){
                maxV =cv;
            }
            return;
        }
        // 选择不装第 i 个物品
        f2(i+1,cw,cv);
        if(cw + weight[i] <= w){
            // 选择装第 i 个物品
            f2(i+2,cw+weight[i],cv+value[i]);
        }
    }

    /**
     * 添加物品个数，重量和价值的操作
     * weight: 物品重量，value 物品的价值，n: 物品个数，w: 背包可承载重量
     */
    public static int knapsack3(int[] weight,int[] value,int n,int w){
        int[][] status = new int[n][w+1];
        // 初始化  status 为  -1
        for(int i = 0; i < n; i++){
            for(int j = 0;j < w+1;j++){
                status[i][j] = -1;
            }
        }

        // 哨兵的初始化操作
        status[0][0] = 0;
        status[0][weight[0]] = value[0];

        // 动态转移
        for(int i = 1; i< n;i++){
            // 不选择第 i 个物品
            for(int j = 0; j <= w; j++){
                if(status[i-1][j] >= 0){
                    status[i][j] = status[i-1][j];
                }
            }
            // 选择第 i 个物品
            for (int j = 0; j < w - weight[i]; j++){
                if(status[i-1][j] > 0){
                    int v = status[i-1][j] + value[i];
                    if(v > status[i][j+weight[i]]){
                        status[i][j+weight[i]] = v;
                    }
                }
            }
        }

        // 找出最大值
        int maxvalue = -1;
        for(int j = 0; j <= w; j++){
            if(status[n-1][j] > maxvalue){
                maxvalue = status[n-1][j];
            }
        }
        return maxvalue;
    }



    public static void main(String[] args) {
//        bagPromble(4,4);
        int[] weight =  new int[]{2,2,4,6,3};
//        int i = knapsack(weight, weight.length, 9);
//        int i = knapsack2(weight, weight.length, 9);
        int[] value = {3,4,8,9,6};
        int i = knapsack3(weight, value,weight.length, 9);
        System.out.println(i);
    }
}
