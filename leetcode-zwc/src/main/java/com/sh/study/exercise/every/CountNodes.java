package com.sh.study.exercise.every;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 * 通过次数43,841提交次数58,752
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/24 9:38
 */
public class CountNodes {

    /**
     * 二叉树的遍历，使用层序遍历吧
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return count;
    }

    /**
     * 第二种方式，基于完全二叉树的定义，
     * 完全二叉树的最左边的节点一定位于最底层，因此从根节点出发，每次访问左子节点，直到遇到叶子节点，该叶子节点即为完全二叉树的最左边的节点，经过的路径长度即为最大层数 h
     *
     * 第 0 <= i < h的时候，第i层包含的节点个数是 2 ^ i ,最底层包含的节点个数是1到 2^h
     *
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/
     *
     * 思路：先计算有多少层，然后最后一层使用二分查找，判断最后一个节点的值是多少
     *
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root) {
        // 先计算二叉树的层次是多少
        if(root == null){
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null){
            level++;
            node = node.left;
        }

        // 在第 level层，最大节点之和最小节点值的个数，通二分查找法确定最终的个数
        int low = 1 << level;
        int high = (1 << (level+1))-1;
        while (low < high){
            int mid = (high-low+1)/2 + low;
            if(exist(root,level,mid)){
                low = mid;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

    /**
     * 判断这个节点是否存在
     * @param root
     * @param level
     * @param mid
     * @return
     */
    private static boolean exist(TreeNode root ,int level, int mid) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0){
            if((bits&mid)==0){
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    public static void main(String[] args) {
        System.out.println(countNodes1(NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
