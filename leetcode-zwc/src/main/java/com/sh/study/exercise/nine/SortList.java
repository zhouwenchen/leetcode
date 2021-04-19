package com.sh.study.exercise.nine;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @Author zhouwenchen
 * @Data 2020/10/22/10
 **/
public class SortList {
    /**
     * 思路一：众所周知，效率低下
     *
     * 遍历链表，存储到 list中
     * 排序list，
     * 重新生成链表
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        List<Integer> lists = new ArrayList<>();
        while (cur != null){
            lists.add(cur.val);
            cur = cur.next;
        }
        // 排序
        Collections.sort(lists);
        // 生成链表
        ListNode dumy = new ListNode(-1);
        cur = null;
        ListNode dumy1 = dumy;
        for (int i = 0; i < lists.size(); i++) {
            ListNode temp = new ListNode(lists.get(i));
            dumy1.next = temp;
            dumy1 = dumy1.next;
        }
        return dumy.next;
    }

    /**
     * 根据步长分割链表
     * 合并两个有序的链表
     *
     * 使用归并排序实现
     * @param head
     * @return
     */
    public static ListNode sortList1(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        // 获取到链表的长度
        int len = listNodeLength(head);

        // 定义头结点
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        // 循环log n 次
        for (int i = 1; i < len; i <<= 1){
            ListNode prev = dumy;
            ListNode curr = dumy.next;

            //循环n次
            while (curr != null){
                ListNode left = curr;
                ListNode right = split(left,i);
                curr = split(right,i);
                prev.next = mergeTwoLists(left, right);

                while (prev.next != null){
                    prev = prev.next;
                }
            }
        }
        return dumy.next;
    }

    /**
     * 排序链表的合并操作
     * @param left
     * @param right
     * @return
     */
    private static ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dumy = new ListNode( -1);
        ListNode cur = dumy;

        while (left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dumy.next;
    }

    /**
     * 根据 step  分割链表
     * @param head
     * @param step
     * @return
     */
    private static ListNode split(ListNode head, int step) {
        if(head == null){
            return null;
        }
        for (int i = 1; head.next != null && i <step; i++){
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    /**
     * 获取到链表的长度
     * @param head
     * @return
     */
    private static int listNodeLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    /**
     * 20210416
     *
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 找到链表的中间节点
        ListNode mid = findMiddle(head);
        ListNode bak = mid.next;
        mid.next = null;

        // 后序遍历左右链表
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(bak);

        // 遍历完成之后，开始将两个有序链表进行合并
        ListNode dumy = new ListNode(-1);
        ListNode tail = dumy;

        // 这里是合并两个有序链表的模板
        while (left != null || right != null){
            if(right == null || left != null && left.val <= right.val){
                tail.next = left;
                tail = left;
                left = left.next;
            }else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }
        tail.next = null;

        return dumy.next;
    }

    // 找到中间节点
    private static ListNode findMiddle(ListNode head) {
        ListNode s1 = head;
        ListNode s2 = head;
        ListNode pre = s1;
        while (s2 != null && s2.next != null){
            pre = s1;
            s1 = s1.next;
            s2 = s2.next.next;
        }
        return s2 != null?s1:pre;
    }


    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3});
//        ListNode resultHead = sortList1(head);
        ListNode resultHead = sortList2(head);
        NodeUtil.printListNode(resultHead);
    }
}
