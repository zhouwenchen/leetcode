package com.sh.study.exercise.every;

import com.sh.study.node.TreeNode;
import com.sh.study.queue.ArrayQueue;
import com.sh.study.util.NodeUtil;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/22 22:10
 */
public class ZigzagLevelOrder {
    /**
     * 二叉树的层序遍历操作
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isOrderLeft = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> levelList  = new LinkedList<>();
            for (int i = 0; i < size;i++){
                TreeNode node = queue.poll();
                if(isOrderLeft){
                    levelList.offerLast(node.val);
                }else {
                    levelList.offerFirst(node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(new ArrayList<>(levelList));
            isOrderLeft =! isOrderLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5, 6, 7});
        List<List<Integer>> lists = zigzagLevelOrder(root);
        lists.stream().forEach(System.out::println);
    }
}
