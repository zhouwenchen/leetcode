package com.sh.study.link.sort;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import java.util.List;

/**
 * 148. 排序链表
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  TODO 链表的排序操作
 * @author ：zhouwenchen
 * @date ： 2020/11/20 10:40
 */
public class SortList {
    /**
     * 使用插入排序
     * 可以详见 InsertionSortList
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = head.next;
        ListNode lastNode = head;
        while (cur != null) {
            if (lastNode.val < cur.val) {
                lastNode = lastNode.next;
            } else {
                // 从头结点遍历，找到需要插入的位置
                ListNode pre = dumy;
                while (pre.next.val < cur.val) {
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

    /**
     * TODO 归并排序,可以参照数组的归并排序 @{MergeSort}
     *
     * @date 20201121
     * @param head
     * @return
     */
    public static ListNode sortList1(ListNode head) {
        // 验证参数的合法性
        if(head == null || head.next == null){
            return head;
        }
        // 找到链表的中间节点，使用快慢指针实现操作
        ListNode midNode = findMidNode(head);
        // 右边链表的头结点
        ListNode rightHead = midNode.next;
        // 断开左链表的链表表尾
        midNode.next = null;

        // 使用递归分别对左链表和右链表进行排序
        ListNode left = sortList1(head);
        ListNode right = sortList1(rightHead);
        // 合并操作
        return merge(left,right);
    }

    /**
     * 当左右链表分开
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;
        // 同时遍历左右两个链表
        while (left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // 如果有一个链表不为空的情况下
        if (left != null){
            cur.next = left;
        }
        if(right != null){
            cur.next = right;
        }
        return dumy.next;
    }

    /**
     * 查找中间节点，使用快慢指针实现操作
     * @param head
     * @return
     */
    private static ListNode findMidNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * TODO 快速排序实现
     * 思路： 已分区和未分区，选择一个分区点，使得小于分区节点的值都在左边，大于分区节点的值都在右边
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }

    private static void quickSort(ListNode head, ListNode end) {
       if(head != end){
           // 选定一个节点作为分区点，使得小于分区点的值在左边，大于分区点的值在右边
           ListNode node = partion(head,end);
           quickSort(head,node);
           quickSort(node.next,end);
       }
    }

    private static ListNode partion(ListNode head, ListNode end) {
        // 假设 p1 左右分区点
        ListNode p1 = head;
        ListNode p2 = head.next;
        // 遍历链表
        while (p2 != end){
            // 大于 key 值时，p1 向前走一步，交换p1 和p2 的值
            if(p2.val < head.val){
                p1 = p1.next;

                int tmp =p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        // 当有序的时候，不交换
        if(p1 != head){
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;
    }

    public static void main(String[] args) {
//        NodeUtil.printListNode(sortList(NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3})));
//        NodeUtil.printListNode(sortList1(NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3})));
        NodeUtil.printListNode(sortList2(NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3})));
    }
}
