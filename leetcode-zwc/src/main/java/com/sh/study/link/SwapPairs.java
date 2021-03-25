package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @Author zhouwenchen
 * @Date  2020-10-13
 **/
public class SwapPairs {
    /**
     * head 记录头结点
     * first 记录第一个节点
     * sencode 记录第二个节点
     * third 记录下一次反转的节点
     * TODO 题意理解有问题 这个是链表的反转功能。。。。。。。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode first = head;
        ListNode sencode = head.next;
        ListNode last = null;
        ListNode third = null;
        while (sencode != null){
            third = sencode.next;
            sencode.next = first;
            first.next = last;
            if(third == null){
               break;
            }
            last = sencode;
            first = third;
            sencode = first.next;
        }
        if(sencode== null && third != null){
            third.next = last;
            return third;
        }
        return sencode;
    }

    /**
     * 使用递归实现操作
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 定义头结点
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode dumyHead = new ListNode(-1);
        dumyHead.next = head;
        ListNode temp = dumyHead;
        while (temp.next != null && temp.next.next !=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 指向头结点
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dumyHead.next;
    }

    public static void main(String[] args) {
        ListNode root = NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4}); //4->3->2->1->null
//        ListNode root = NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4,5});
//        ListNode result = swapPairs2(root);
        ListNode result = swapPairs1(root);
        NodeUtil.printListNode(result);
    }
}
