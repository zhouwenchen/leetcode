package com.sh.study.offer;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 * @author zhouwenchen
 * @date 2021/9/7 10:26
 **/
public class ReverseList {
    /**
     * 1：我能想到的还是很简单的思路，遍历链表，将所有的数据取出来，比如存入栈中，之后取出栈中的元素，重新生成链表
     * 2：思考的点，如果一次就生成反转链表
     *
     * 递推公式
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 递推实现操作
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null,cur = head;
        while (cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }


    public static void main(String[] args) {
//        ListNode result = reverseList(NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5}));
        ListNode result = reverseList1(NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5}));
        NodeUtil.printListNode(result);
    }
}
