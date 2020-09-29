package com.sh.study.exercise.second;

import com.sh.study.node.TreeNode;

import java.util.*;

/**
 * 二叉树的遍历操作
 * 66. 二叉树的前序遍历
 * 给出一棵二叉树，返回其节点值的前序遍历。
 *
 * 样例
 * Example 1:
 *
 * Input：{1,2,3}
 * Output：[1,2,3]
 * 解释：
 * 前序遍历
 * Example 2:
 *
 * Input：{1,#,2,3}
 * Output：[1,2,3]
 * 解释：
 * 前序遍历
 * 挑战
 * 你能使用非递归实现么？
 *
 * 注意事项
 * 首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#"表示不存在该子节点。
 * 节点数量不超过20
 *
 *       1
 *     /   \
 *    2     3
 *   / \   /  \
 *  4  5  6    7
 *
 * 二叉树节点为 1,2,3,4,5,6,7
 * 前序遍历：1 2 4 5 3 6 7
 * 中序遍历：4 2 5 1 6 3 7
 * 后序遍历：4 5 2 6 7 3 1
 * 层次遍历：1 2 3 4 5 6 7
 * 深度优先：1 2 4 5 3 6 7
 *
 * @Author zhouwenchen
 * @Data 2020/8/14/20
 **/
public class Traversal {

    /**
     * 前序遍历，非递归，使用栈实现，先右节点后左节点入栈操作
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return res;
    }

    /**
     * 前序遍历  使用链表实现，先入左节点，直到左节点没有的时候，然后记录当前节点的上一个父节点 ，右节点进入 链表
     *
     * TODO 这种解法使用链表，好像可以使用 stack 来实现的操作，因为当遍历到 root.left = null,需要定位到当前节点的父节点，然后遍历右节点
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<TreeNode> p = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || p.size() != 0){
            while (root != null){
                p.add(root);
                res.add(root.val);
                root = root.left;
            }
            int loc = p.size() - 1;
            root = p.get(loc);
            p.remove(loc);
            root = root.right;
        }
        return res;
    }

    /**
     * 前序遍历 使用递归的方式实现
     * @param root
     * @return
     */
    private static List<Integer> resultList = new ArrayList<Integer>();
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if(root != null){
            resultList.add(root.val);
            preorderTraversal2(root.left);
            preorderTraversal2(root.right);
        }
        return resultList;
    }

    // TODO ===========================

    /**
     * 中序遍历  使用基于链表的形式
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> p = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || p.size() != 0){
            while (root != null){
                p.add(root);
                root = root.left;
            }
            int loc = p.size() - 1;
            root = p.get(loc);
            p.remove(loc);
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 中序遍历  递归的实现
     * @param root
     * @return
     */
    private static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if(root != null){
            inorderTraversal1(root.left);
            res.add(root.val);
            inorderTraversal1(root.right);
        }
        return res;
    }

    // TODO =================================

    /**
     * 后序遍历 递归实现
     * @param rootif
     * @return
     */
    private static List<Integer> res1 = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root){
         if(root != null) {
             postorderTraversal(root.left);
             postorderTraversal(root.right);
             res1.add(root.val);
         }
        return res1;
    }

    /**
     * 后序遍历  非递归实现
     * 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，按照从上到下、从左至右的顺序依次压入栈中。
     * LinkedList 节点后出，数据放入到链表的头结点位置
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root){
        LinkedList<TreeNode> statck = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        statck.add(root);
        while (!statck.isEmpty()){
            TreeNode node = statck.pollLast(); // TODO 精髓的两句操作
            res.addFirst(node.val); // TODO res.add(node.val)   链表顺序是反着遍历的
            if(node.left != null){
                statck.add(node.left);
            }
            if(node.right != null){
                statck.add(node.right);
            }
        }
        return res;
    }

    /**
     * 后序遍历，以上使用的方式是  LinkedList 存储节点数据，LinkedList 存储数据
     * 如果存储节点的数据  使用  Stack, LinkedList 存储数据节点
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return res;
    }

    /**
     * 后序遍历，使用栈操作，加一个表示  flag，用于表示某一个父节点的右节点是否访问过的标识
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode flag = null;
        List<Integer> res = new ArrayList<>();
        // 先遍历所有的左子树的左节点
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            // cur 的右节点为空，或者右节点已经遍历了
            if(cur.right == null || cur.right == flag){
                res.add(cur.val);
                flag = cur;
            } else {
                // 表示cur 的 右节点不为空，或者没有遍历的情况
                stack.push(cur);
                cur = cur.right;
                // 遍历右节点的下一个左节点
                while (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
    }

    // TODO =====================

    /**
     * 层次遍历,使用 linkedlist 实现操作
     * @param root
     * @return
     */
    public static List<Integer> levelTraverse(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        return res;
    }

    /**
     * 层次遍历，和以上需求不同的是，返回值是不同的
     * [
     *   [1],
     *   [2,3],
     *   [4,5,6,7]
     * ]
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> res = null;
        if(root == null){
            return resultList;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int size = 0;
        while (!stack.isEmpty()){
            // 记录 statck 种的长度
            size = stack.size();
            res = new ArrayList<>();
            while (size-- > 0){
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.left != null){
                    stack.add(node.left);
                }
                if(node.right != null){
                    stack.add(node.right);
                }
            }
            resultList.add(res);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

//		TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//		node7.right = node8;
//		List<Integer> list = inorderTraversal1(node1);
//		List<Integer> list = inorderTraversal(node1);
 		List<Integer> list = postorderTraversal2(node1);
// 		List<Integer> list = levelTraverse(node1);
//        List<List<Integer>> list = levelOrder(node1);
//        List<Integer> list = preorderTraversal2(node1);
        list.stream().forEach( o -> System.out.print(o + " "));


    }
}
