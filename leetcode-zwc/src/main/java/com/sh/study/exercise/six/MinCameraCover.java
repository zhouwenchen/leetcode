package com.sh.study.exercise.six;

import com.sh.study.node.TreeNode;

import javax.swing.*;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 * @Author zhouwenchen
 * @Date 2020-09-22
 **/
public class MinCameraCover {

    public static int res = 0;

    /**
     * 使用后续遍历实现
     *
     * @param root 根节点
     * @return
     */
    public static int minCameraCover(TreeNode root) {
        //0未被监控  1已被监控   2该节点安装监控器
        //后序遍历，从下自上遍历。
        //若遍历至最上面，root标志为0，则多加一个摄像头
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        //左右孩子中有一个未被覆盖，则当前节点需要放置摄像头，当前节点标志为2
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        //左右孩子均为已覆盖状态,则当前节点未被覆盖，标志为0
        if (left == 1 && right == 1) {
            return 0;
        }
        //若左右孩子为一个覆盖一个放置了摄像头，则当前节点为已被覆盖，标志为1
        if (left + right >= 3) {
            return 1;
        }
        //此时已经组合完了根节点所有情况，随便返回一个整数即可
        return 0;
    }

    public static void main(String[] args) {
//        minCameraCover(null);
    }
}
