package com.sh.study.link;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/12 19:36
 */
public class AddTwoNumbers {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode dumy = head;
        int digit = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + digit;
            int sigle = 0;
            ListNode node = null;
            if(sum >=10){
                //single digit
                digit = sum / 10;
                sigle = sum % 10;
                node = new ListNode(sigle);
            }else {
                digit = 0;
                node = new ListNode(sum);
            }

            head.next = node;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        // 表示没有进位

        if(l1 == null){
            while (l2 != null){
                int sum = l2.val + digit;
                int sigle = 0;
                ListNode node = null;
                if(sum >=10){
                    //single digit
                    digit = sum / 10;
                    sigle = sum % 10;
                    node = new ListNode(sigle);
                }else {
                    digit = 0;
                    node = new ListNode(sum);
                }

                head.next = node;
                l2 = l2.next;
                head = head.next;
            }
        }
        if(l2 == null){
           while (l1 != null){
               int sum = l1.val + digit;
               int sigle = 0;
               ListNode node = null;
               if(sum >=10){
                   //single digit
                   digit = sum / 10;
                   sigle = sum % 10;
                   node = new ListNode(sigle);
               }else {
                   digit = 0;
                   node = new ListNode(sum);
               }

               head.next = node;
               l1 = l1.next;
               head = head.next;
           }
        }
        if(digit==1){
            head.next = new ListNode(digit);
        }
        return dumy.next;
    }

    /**
     * 官方的简洁版本信息：简化的版本信息
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 !=null? l1.val:0;
            int n2 = l2 !=null? l2.val:0;

            int sum = n1 + n2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = NodeUtil.createListNodeByArr(new int[]{2, 4, 3});
//        ListNode l2 = NodeUtil.createListNodeByArr(new int[]{5, 6, 4});
        ListNode l1 = NodeUtil.createListNodeByArr(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = NodeUtil.createListNodeByArr(new int[]{9,9,9,9});

        ListNode resultNode = addTwoNumbers1(l1, l2);
        NodeUtil.printListNode(resultNode);
    }
}
