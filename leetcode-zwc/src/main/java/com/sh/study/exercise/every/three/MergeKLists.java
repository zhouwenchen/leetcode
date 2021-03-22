package com.sh.study.exercise.every.three;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import javax.management.Query;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
 */
public class MergeKLists {

    /**
     * 将数组中的数据存入到优先级队列中
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        final int n = lists == null ? 0 : lists.length;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < n; i++){
            ListNode tmp = lists[i];
            if(tmp != null){
                priorityQueue.add(tmp);
            }
        }

        ListNode dumy = new ListNode(-1);
        ListNode tail = dumy;

        while (!priorityQueue.isEmpty()){
            ListNode cur = priorityQueue.poll();
            tail.next = cur;
            tail = cur;
            if(cur.next != null){
                priorityQueue.add(cur.next);
            }
        }
        tail.next = null;
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = NodeUtil.createListNodeByArr(new int[]{1, 4, 5});
        ListNode list2 = NodeUtil.createListNodeByArr(new int[]{1,3,4});
        ListNode list3 = NodeUtil.createListNodeByArr(new int[]{2,6});
        ListNode[] lists = new ListNode[]{list1,list2,list3};
        ListNode head = mergeKLists(lists);
        NodeUtil.printListNode(head);
    }
}
