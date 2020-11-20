package com.sh.study.link.sort;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

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



    public static void main(String[] args) {
        NodeUtil.printListNode(sortList(NodeUtil.createListNodeByArr(new int[]{4, 2, 1, 3})));
    }
}
