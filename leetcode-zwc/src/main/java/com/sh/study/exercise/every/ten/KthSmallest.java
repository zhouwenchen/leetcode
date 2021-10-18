package com.sh.study.exercise.every.ten;

import com.sh.study.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 *
 *
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * @author zhouwenchen
 * @date 2021/10/18 10:03
 **/
public class KthSmallest {
    /**
     * 如果直接遍历整个二叉搜索树，将结果放入到优先级队列的话，那么 二叉搜索树就没有任何意义了呀？ TODO
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b) ->b-a );
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(priorityQueue.size() < k){
                priorityQueue.add(node.val);
            }else if(priorityQueue.peek() > node.val){
                priorityQueue.poll();
                priorityQueue.add(node.val);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return priorityQueue.peek();
    }

    /**
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
//        System.out.println(kthSmallest(node3, 1));
        System.out.println(kthSmallest1(node3, 2));
    }
}
