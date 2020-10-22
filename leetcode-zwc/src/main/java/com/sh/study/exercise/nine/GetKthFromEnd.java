package com.sh.study.exercise.nine;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * @Author zhouwenchen
 * @Data 2020/10/22/11
 **/
public class GetKthFromEnd {
    /**
     * 思路1：可能比较简单的想法就是，先遍历链表，获取到链表的长度 len，然后 len -k，也就是链表中倒数第k个节点
     * 思路2：以上的思路遍历了两次链表，以下使用快慢指针
     *         快指针先执行k个节点，然后快慢指针一同执行k个节点，直达快指针叨叨链表尾部，则慢指针到达的位置，也就是 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        // 快指针先执行k步
        ListNode fast = head;
        for (int i = 0; i < k; i++){
            fast = fast.next;
        }
        // 快慢指针一同遍历，直到快指针到达链表尾部
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode resultHead = getKthFromEnd(NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5}), 2);
        NodeUtil.printListNode(resultHead);
    }
}
