package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author zhouwenchen
 * @date 2021/3/22 20:11
 **/
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
//        ListNode pre = dumy;
        ListNode cur = dumy.next;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return dumy.next;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode cur = pre.next;
        while (cur != null){
            int count = 0;
            ListNode diffNode = cur;
            // 找到 diffNode 和 cur 不同的节点
            while (diffNode != null && diffNode.val == cur.val){
                count++;
                diffNode = diffNode.next;
            }
            if(count > 1){
                pre.next = diffNode;
            }else {
                pre = cur;
            }
            cur = diffNode;
        }
        return dumy.next;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 思路，统计重复的元素，直接跳过
     * @date 20210325
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode cur = dumy.next;

        while (cur != null){
            int count = 0;
            ListNode differNode = cur;
            while (differNode.next != null && differNode.val == differNode.next.val){
                count++;
                differNode = differNode.next;
            }
            if(count > 0){
                pre.next = differNode.next;
            }else {
                pre = cur;
            }
            cur = differNode.next;
        }

        return dumy.next;
    }


    public static void main(String[] args) {
//        ListNode result = deleteDuplicates3(NodeUtil.createListNodeByArr(new int[]{1, 1, 2, 3, 3,3}));
//        ListNode result = deleteDuplicates3(NodeUtil.createListNodeByArr(new int[]{1, 1, 1, 2, 3}));  //2->3->null
        ListNode result = deleteDuplicates3(NodeUtil.createListNodeByArr(new int[]{1, 1, 2, 3, 3,4,4,5}));
//        ListNode result = deleteDuplicates3(NodeUtil.createListNodeByArr(new int[]{1,2,3,3,4,4,5}));
        NodeUtil.printListNode(result);
    }
}
