package com.sh.study.exercise.first;


import com.sh.study.node.ListNode;

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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node4;
        node4.next = node5;

        ListNode node11 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        node11.next = node3;
        node3.next = node44;

        ListNode listNode = mergeTwoLists(node1, node11);
        if(listNode != null){
            while (listNode != null){
                System.out.print(listNode.val + "->");
                listNode = listNode.next;
            }
            System.out.println("->null");
        }
    }
}
