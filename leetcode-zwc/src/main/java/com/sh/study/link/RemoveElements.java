package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * @author zhouwenchen
 * @date 2021/3/22 19:54
 **/
public class RemoveElements {
    /**
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode tmp = dumy, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                tmp.next = curr.next;
            }else {
                tmp = curr;
            }
            curr = curr.next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = removeElements(NodeUtil.createListNode(6), 5);
        NodeUtil.printListNode(listNode);
    }
}
