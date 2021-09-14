package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * @author zhouwenchen
 * @date 2021/9/13 10:16
 **/
public class LevelOrder {
    /**
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (node.right != null) {
                stack.addLast(node.right);
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     *
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     * 提示：
     *
     * 节点总数 <= 1000m
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return  results;
        }
        List<Integer> list ;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            list = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            results.add(list);
        }

        return results;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     *
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     *
     * 提示：
     *
     * 节点总数 <= 1000
     *
     * TODO 没有实现操作
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return  results;
        }
        Deque<Integer> list ;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean isRevers = false;
        while (!deque.isEmpty()){
            int len = deque.size();
            isRevers  = !isRevers;
            list = new LinkedList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = deque.pollFirst();
                if(isRevers){
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }

            }
            results.add(new ArrayList<>(list));
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

//        Arrays.stream(levelOrder(node3)).forEach(o->System.out.print(o+"\t")); // [3,9,20,15,7]
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5});
//        Arrays.stream(levelOrder(root)).forEach(o->System.out.print(o+"\t")); // [1	2	3	4	5	]

//        levelOrder1(node3).stream().forEach(o-> System.out.println(o+"\t"));
        levelOrder2(node3).stream().forEach(o-> System.out.println(o+"\t"));
        System.out.println("============");
        levelOrder2(root).stream().forEach(o-> System.out.println(o+"\t"));




    }
}
