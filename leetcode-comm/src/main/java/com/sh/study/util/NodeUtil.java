package com.sh.study.util;


import com.sh.study.node.ListNode;
import com.sh.study.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输出的 Util
 *
 * @Author zhouwenchen
 * @Data 2020/8/10/14
 **/
public class NodeUtil {

    /**
     * 顺序生成链表
     * createListNode（5）,生成链表  1->2->3->4->5->null
     *
     * @param k 生成链表的长度和最大值
     * @return
     */
    public static ListNode createListNode(int k) {
        ListNode headtemp = new ListNode(-1);
        ListNode head = headtemp;
        for (int i = 1; i <= k; i++) {
            ListNode temp = new ListNode(i);
            headtemp.next = temp;
            headtemp = headtemp.next;
        }
        return head.next;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    /**
     * 将数组转化成链表
     *
     * @param arr 目标数组
     * @return
     */
    public static ListNode createListNodeByArr(int[] arr) {
        ListNode headtemp = new ListNode(-1);
        ListNode head = headtemp;
        for (int i = 0; i <= arr.length - 1; i++) {
            ListNode temp = new ListNode(arr[i]);
            headtemp.next = temp;
            headtemp = headtemp.next;
        }
        return head.next;
    }

    /**
     * 根据数组生成树的结构 {5, 3, 7, 2, 4, 6, 8} 生成
     *        5
     *      /   \
     *     3     7
     *    / \   /  \
     *   2  4  6    8
     *
     * @param arr
     * @return
     */
    public static TreeNode createTreeNodeByArr(int[] arr){
        TreeNode root = createTreeNode(arr, 1);
        return root;
    }

    private static TreeNode createTreeNode(int[] array, int index) {
        if(index > array.length){
            return null;
        }
        Integer value = array[index - 1];
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2);
        node.right = createTreeNode(array, index * 2 + 1);
        return node;
    }

    /**
     * 根据 root 进行层序遍历节点
     * @param root
     * @return
     */
    private static List<Integer> levelOrder(TreeNode root){
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
     * 根据树的root节点，层序遍历树节点
     * @param root
     */
    public static void printTreeNodeByLevelOrder(TreeNode root){
        List<Integer> list = levelOrder(root);
        list.stream().forEach(o ->System.out.print(o+"\t"));
    }



    public static void main(String[] args) {
//        ListNode head = createListNode(5);
//        ListNode head = createListNodeByArr(new int[]{4, 6, 8, 2});
//        printListNode(head);

        TreeNode head = createTreeNodeByArr(new int[]{5, 3, 7, 2, 4, 6, 8});
        printTreeNodeByLevelOrder(head);
    }
}
