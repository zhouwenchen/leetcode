package com.sh.study.exercise.nine;

import com.sh.study.node.ListNode;
import com.sh.study.node.Node;
import com.sh.study.util.NodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 * @Author zhouwenchen
 * @Data 2020/10/27/11
 **/
public class MergeKLists {

    /**
     * 思路1：遍历所有的数据，存入到list集合中，排序，然后生成链表
     * 思路2：两两链表进行遍历，然后生成一个排序的链表，之后再和其他的链表生成链表
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> data = new ArrayList<>();
        for (ListNode head : lists){
            while (head != null){
                data.add(head.val);
                head = head.next;
            }
        }
        // 排序
        Collections.sort(data);
        // 生成链表
        ListNode dumy = new ListNode(-1);
        ListNode head = null;
        head = dumy;
        for (int i = 0; i < data.size();i++){
            ListNode temp = new ListNode(data.get(i));
            dumy.next = temp;
            dumy = dumy.next;

        }
        return head.next;
    }

    /**
     * 两两个链表之间进行替换
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null){
            return null;
        }

        ListNode dumy = new ListNode(-1);
        for (ListNode head: lists){
            // 第一个链表
            if(dumy.next == null){
                dumy.next = head;
                continue;
            }
            // 两两链表进行合并
            ListNode temp = dumy;
            while (temp.next != null && head != null){
                if(temp.next.val < head.val){
                    temp = temp.next;
                } else {
                    // 先把链表2保存
                    ListNode node1 = temp.next;
                    ListNode node2 = head.next;
                    temp.next = head;
                    head.next = node1;
                    temp = temp.next;
                    head = node2;
                }
            }
            if(temp.next == null && head != null){
                temp.next = head;
            }
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = NodeUtil.createListNodeByArr(new int[]{1,4,5});
        ListNode node2 = NodeUtil.createListNodeByArr(new int[]{1,3,4});
        ListNode node3 = NodeUtil.createListNodeByArr(new int[]{2,6});
        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        ListNode head = mergeKLists1(lists);
        NodeUtil.printListNode(head);
    }
}
