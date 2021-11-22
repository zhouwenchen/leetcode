package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @Author zhouwenchen
 * @Data 2020/10/21/15
 **/
public class ReverseBetween {
    /**
     * 先遍历到m处，开始反转链表知道 n处结束
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        // 遍历链表,直到需要反转的地方
        ListNode dumy = new ListNode(-1);
        ListNode pre = dumy;
        dumy.next = head;
        for (int i = 1; i <m; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++){
            ListNode temp = cur.next;
            //cur将nxt节点后面的链表连接起来
            cur.next=temp.next;
            //将nxt插入到pre后面
            temp.next=pre.next;
            pre.next=temp;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNodeByArr(new int[]{1, 2, 3, 4, 5,6,7,8,9});
        ListNode resultHead = reverseBetween(head, 2, 6);
        NodeUtil.printListNode(resultHead);
    }
}
