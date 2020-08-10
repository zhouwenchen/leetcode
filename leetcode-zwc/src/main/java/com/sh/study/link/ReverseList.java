package com.sh.study.link;

import com.sh.study.node.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @Author zhouwenchen
 * @Data 2020/8/10/11
 **/
public class ReverseList {

    /**
     * 先遍历链表存入到 stack 中 ，然后重新组装链表 ，这种方式不可取
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        temp = new ListNode(-1);
        ListNode headtemp = temp;
        ListNode newListNode = null;
        while (!stack.isEmpty()) {
            newListNode = new ListNode(stack.pop());
            temp.next = newListNode;
            temp = temp.next;
        }
        return headtemp.next;
    }

    /**
     * 迭代
     * 在遍历链表的时候，记录一下当前节点的前一个节点，并将当前节点的next 指向 前一个节点
     *
     * @param head 头结点
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = reverseList2(node1);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("->null");
    }
}
