package com.sh.study.link.sort;

import com.sh.study.node.ListNode;
import com.sh.study.node.Node;
import com.sh.study.util.NodeUtil;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/20 9:38
 */
public class InsertionSortList {

    /**
     * 官网的题解
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = head.next;
        ListNode lastNode = head;
        while (cur != null){
            if(lastNode.val < cur.val){
                lastNode = lastNode.next;
            } else {
                ListNode pre = dumy;
                while (pre.next.val < cur.val){
                    pre = pre.next;
                }
                lastNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastNode.next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode result = NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3});
        NodeUtil.printListNode(insertionSortList(result));
    }
}
