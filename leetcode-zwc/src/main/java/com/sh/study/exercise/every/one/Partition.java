package com.sh.study.exercise.every.one;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * @Author zhouwenchen
 * @Date
 **/
public class Partition {

    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        /**
         * 使用两个链表，small 和 large
         */
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;
        while (head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // 合并两个链表
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode head = partition(NodeUtil.createListNodeByArr(new int[]{1, 4, 3, 2, 5, 2}), 3);
        ListNode resultHead = partition(head, 3);
        NodeUtil.printListNode(resultHead);
    }
}
