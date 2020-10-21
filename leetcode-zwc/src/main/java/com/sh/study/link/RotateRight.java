package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.node.Node;
import com.sh.study.util.NodeUtil;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @Author zhouwenchen
 * @Data 2020/10/21/16
 **/
public class RotateRight {
    /**
     * 第一次先遍历获取链表的长度 len
     * 将链表每个节点向右移动 k 个位置，就相当远最后几个位置移动，len -（k%len）,也就是从这开始后面的旋转到开头
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        // 第一次遍历，获取到链表的长度,并记录最后一个链表的指针
        ListNode cur = head;
        ListNode tail = null;
        int len = 0;
        while (cur != null){
            tail = cur;
            cur = cur.next;
            len++;
        }

        // 遍历直到   len - k 次
        int m = k % len;
        if(m==0){
            return head;
        }
        cur = head;
        ListNode pre = cur;
        for (int i = 0; i < len - m;i++){
            pre = cur;
            cur = pre.next;
        }
        tail.next = head;
        pre.next = null;
        return cur;
    }

    public static void main(String[] args) {
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5});
//        ListNode resultNode = rotateRight(head, 2);
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{0,1, 2});
//        ListNode resultNode = rotateRight(head, 4);

        ListNode head = NodeUtil.createListNodeByArr(new int[]{1});
        ListNode resultNode = rotateRight(head, 1);
        NodeUtil.printListNode(resultNode);
    }
}
