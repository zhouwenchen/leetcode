package com.sh.study.dynamic;

/**
 * @author zhouwenchen
 * @date 2020-08-23 08:00
 */
public class MinDistBT {

    /**
     * // 调用方式：minDistBacktracing(0, 0, 0, w, n);
     * TODO 测试有问题
     */
    private  static int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了 n -1 ,n - 1 这个位置
        if(i == n && j == n){
            if(dist < minDist){
                minDist = dist;
            }
            return;
        }

        if(i < n ){
            minDistBT(i+1,j,dist+w[i][j],w,n);
        }
        if(j < n){
            minDistBT(i,j+1,dist+w[i][j],w,n);
        }
    }

    public static int minDistDP(int[][] matrix,int n){
        int[][] stats = new int[n][n];
        int sum = 0;
        // 初始化 states 的第一行数据
        for(int j = 0; j < n ;++j){
            sum += matrix[0][j];
            stats[0][j]=sum;
        }
        // 初始化 states 的第一列数据
        sum = 0;
        for(int i = 0; i < n;i++){
            sum += matrix[i][0];
            stats[i][0] = sum;
        }
        for(int i = 1; i < n;++i){
            for(int j = 1;j < n;++j){
                stats[i][j] = matrix[i][j] + Math.min(stats[i][j-1],stats[i-1][j]);
            }
        }
        return stats[n-1][n-1];
    }



    public static void main(String[] args) {
        MinDistBT minDistBT = new MinDistBT();
        int[][] dist = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
//        minDistBT.minDistBT(0,0,0,dist,4);
        int i = minDistDP(dist, 3);
        System.out.println(i);
    }
}
