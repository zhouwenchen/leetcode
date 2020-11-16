package com.sh.study.exercise.every;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/13 9:37
 */
public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode head1 = head;
        ListNode first = head1;
        ListNode head2 = head.next;
        ListNode sencode = head2;
        boolean flag = true;
        while (first.next != null && sencode.next != null){
            first.next = sencode.next;
            first = first.next;
            if(first.next != null){
                sencode.next = first.next;
                sencode = sencode.next;
            } else {
                sencode.next = null;
                first.next = head2;
                flag = false;
            }
        }
        if(flag){
            sencode.next = null;
            first.next = head2;
        }
        return head1;
    }

    public static void main(String[] args) {
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{2, 1, 3, 5, 6, 4, 7});//2->3->6->7->1->5->4->null
        ListNode head = NodeUtil.createListNodeByArr(new int[]{2, 1, 3, 5, 6, 4});//2->3->6->1->5->4->null
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{1,2,3,4,5});// 1->3->5->2->4->null
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{1,2,3,4});// 1->3->2->4->null
        ListNode resultHead = oddEvenList(head);
        NodeUtil.printListNode(resultHead);
    }
}
