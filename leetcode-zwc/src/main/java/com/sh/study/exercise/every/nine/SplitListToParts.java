package com.sh.study.exercise.every.nine;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import java.util.Arrays;

/**
 * 725. 分隔链表
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 *
 * @author zhouwenchen
 * @date 2021/9/22 14:03
 **/
public class SplitListToParts {
    /**
     * 先遍历链表获取到链表的长度信息
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode head, int k) {
        // 第一次获取到链表的长度
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        // 可以分割多少个链表
        int count = len / k;
        int moreCount = len % k;
        ListNode[] parts = new ListNode[k];

        ListNode cur = head;
        for (int i = 0; i < k && cur != null ;i++){
            parts[i] = cur;
            int partSize = count + (i < moreCount ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return parts;
    }

    public static void main(String[] args) {
//        Arrays.stream(splitListToParts(NodeUtil.createListNode(10), 3)).forEach(NodeUtil::printListNode);
        Arrays.stream(splitListToParts(NodeUtil.createListNode(0), 3)).forEach(NodeUtil::printListNode);
    }
}
