package com.sh.study.util;


import com.sh.study.node.ListNode;

/**
 * 输出的 Util
 *
 * @Author zhouwenchen
 * @Data 2020/8/10/14
 **/
public class NodeUtil {

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

    public static void main(String[] args) {
        ListNode head = createListNode(5);
        printListNode(head);
    }
}
