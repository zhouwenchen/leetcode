package com.leetcode.lxj.day0809;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        int[] input = {1, 3, 2,4,62,623};
        ListNode head = new ListNode(input[0]);
        ListNode curr = head;
        for (int i = 1; i <input.length; i++) {
            ListNode node = new ListNode(input[i]);
            curr.next = node;
            curr = node;
        }

        int[] ints = reversePrint(head);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(0, current.val);
            current = current.next;
        }
        return list.stream().mapToInt(value -> value).toArray();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}