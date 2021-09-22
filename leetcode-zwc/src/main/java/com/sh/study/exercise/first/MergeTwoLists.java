package com.sh.study.exercise.first;


import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @Author zhouwenchen
 * @Data 2020-08-2020/8/7-20
 **/
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (node1 != null  && node2 != null){
            if(node1.val < node2.val){
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if(node1 != null){
            temp.next = node1;
        }
        if(node2 != null){
            temp.next = node2;
        }
        return head.next;
    }

    /**
     * 以上可以进行优化操作
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoLists3(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (node1 != null && node2 != null){
            if(node1.val < node2.val){
                tail.next = node1;
                tail = node1;
                node1 = node1.next;
            }else {
                tail.next = node2;
                tail = node2;
                node2 = node2.next;
            }
        }
        tail.next = node1 == null? node2:node1;
        tail = tail.next;
//        tail.next = null;
        return head.next;
    }

    /**
     * 202103231133
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode node1, ListNode node2) {
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        ListNode dumy = new ListNode(-1);
        ListNode tail = dumy;
        while (node1 != null || node2 != null){
            if(node2 == null || node1 != null && node1.val < node2.val){
                tail.next = node1;
                tail = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                tail = node2;
                node2 = node2.next;
            }

        }
        tail.next = null;
        return dumy.next;
    }

    public static void main(String[] args) {

//        ListNode node1 = NodeUtil.createListNodeByArr(new int[]{1, 2, 4, 5});
//        ListNode node2 = NodeUtil.createListNodeByArr(new int[]{1, 3, 4});
////        ListNode result = mergeTwoLists(node1, node2);
//        ListNode result = mergeTwoLists1(node1, node2);
//        NodeUtil.printListNode(result);

        NodeUtil.printListNode(mergeTwoLists3(NodeUtil.createListNodeByArr(new int[]{1,2,3,5}),
                NodeUtil.createListNodeByArr(new int[]{1,3,4})));
    }
}
