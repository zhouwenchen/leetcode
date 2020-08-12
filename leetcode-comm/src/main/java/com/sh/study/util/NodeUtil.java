package com.sh.study.util;


import com.sh.study.node.ListNode;

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

    public static void main(String[] args) {
//        ListNode head = createListNode(5);
        ListNode head = createListNodeByArr(new int[]{4, 6, 8, 2});
        printListNode(head);
    }
}
