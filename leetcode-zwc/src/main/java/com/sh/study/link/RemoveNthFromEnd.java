package com.sh.study.link;


import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * @Author zhouwenchen
 * @Data 2020/8/10/14
 **/
public class RemoveNthFromEnd {

    /**
     * 思路1：先遍历一遍链表，判断整个链表的长度，那么就可以定位倒数第n个节点的位置
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null){
            count++;
            node = node.next;
        }

        // 需要删除的位置也就是   count - n 后的节点
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;
        node = resultNode;
        for(int i = 0; i < count - n ;i++){
            resultNode = resultNode.next;
        }

        resultNode.next = resultNode.next.next;
        return node.next;
    }

    /**
     * 思路2：使用一次遍历的方式实现，使用两个指针，第一个指针先于第二指针先走第 N 步，当第一个指针到达链表的尾部，第二个 指针刚好处于删除节点的位置
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;
        ListNode fast = resultNode;
        ListNode slow = resultNode;
        // fast 先执行 n步
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
       return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNode(2);
        ListNode resultHead = removeNthFromEnd2(head, 2);
        NodeUtil.printListNode(resultHead);
    }
}
