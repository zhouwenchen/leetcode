package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author zhouwenchen
 * @date 2021/9/24 11:22
 **/
public class KthLargest {

    /**
     * 遍历，将数据存入到优先级队列中
     * @param root
     * @param k
     * @return
     */
    public static int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if(priorityQueue.size() < k){
                priorityQueue.add(node.val);
            }else if(priorityQueue.peek() < node.val){
                priorityQueue.poll();
                priorityQueue.add(node.val);
            }
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.add(node.right);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{3, 1, 4, -1, 2});
        System.out.println(kthLargest(root, 2));
    }
}
