package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * @author zhouwenchen
 * @date 2021/3/23 15:18
 **/
public class ReverseKGroup {

    /**
     * 遍历链表，将数据存入到队列中
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        Deque<ListNode> queue = new ArrayDeque<ListNode>();
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = dumy.next;
        ListNode newHead = dumy;
        int m = k;
        ListNode listNode = null;
        while (cur != null){
            if (m-- > 0){
                queue.addLast(cur);
                cur = cur.next;
            }else {
                while (!queue.isEmpty()){
                    listNode = queue.pollLast();
                    newHead.next = new ListNode(listNode.val);
                    newHead = newHead.next;
                }
                m = k;
            }
        }
        if(m > 0){
            while (!queue.isEmpty()){
                listNode = queue.pollFirst();
                newHead.next = new ListNode(listNode.val);
                newHead = newHead.next;
            }
        }else {
            while (!queue.isEmpty()){
                listNode = queue.pollLast();
                newHead.next = new ListNode(listNode.val);
                newHead = newHead.next;
            }
        }
        return dumy.next;
    }

    public static void main(String[] args) {
//        ListNode result = reverseKGroup(NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5}), 4);
        ListNode result = reverseKGroup(NodeUtil.createListNodeByArr(new int[]{1, 2}), 2);
        NodeUtil.printListNode(result);
    }
}
