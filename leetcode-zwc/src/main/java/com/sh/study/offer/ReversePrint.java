package com.sh.study.offer;

import com.sh.study.node.ListNode;
import com.sh.study.util.NodeUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/7 10:13
 **/
public class ReversePrint {
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            result[i++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = NodeUtil.createListNodeByArr(new int[]{1, 3, 2});
        Arrays.stream(reversePrint(head)).forEach(System.out::println);
    }
}
