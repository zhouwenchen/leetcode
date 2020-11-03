package com.sh.study.exercise.nine;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @Author zhouwenchen
 * @Data 2020/10/23/09
 **/
public class IsPalindrome {

    /**
     * 时间复杂度是o(n)，也就是只能遍历一遍
     * 遍历一遍链表，将数据存储到数组中，使用双指针实现比较操作
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        // 使用前后指针实现
        int start = 0;
        int end = list.size() - 1;
        while (start < end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 使用快慢指针获取到中间节点的位置
     * 然后从中间节点开始，反转后面得了链表
     * 比较前半部分的链表和后半部分反转之后的链表进行比较
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // 如果fast 不为空的话，说明 链表为奇数
        if(fast != null){
            slow = slow.next;
        }
        // 反转后面的链表
        slow = reverse(slow);

        // 判断两个链表是否相等
        fast = head;
        while (slow != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 链表的反转操作
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNodeByArr(new int[]{1, 2, 2, 1});
//        ListNode head = NodeUtil.createListNodeByArr(new int[]{1, 2});
        System.out.println(isPalindrome1(head));
    }
}
