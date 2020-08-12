package com.leetcode.lxj.dataconstruct.linkedlist.entity;

public class SingleLinkedList<T> {
    private Node<T> head = new Node<>();
    private Node<T> foot = head;

    public void add(T t) {
        Node<T> node = new Node<>();
        node.data = t;
        foot.next = node;
        foot = node;
    }

    public Node<T> remove(T t) {
        Node<T> node = find(t);
        if (node != null) {
            Node<T> result = node.next;
            node.next = node.next.next;
            if (result.next == null) {
                foot = node;
            }
            return result;
        }
        return null;
    }

    public Node<T> find(T t) {
        if (t == null) {
            return null;
        }
        Node<T> tmp = head;
        while (tmp.next != null) {
            if (t.equals(tmp.next.data)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void reverse() {
        if (head.next == null) {
            return;
        }

        Node<T> curr = head.next;
        Node<T> pre = head;
        Node<T> next = curr.next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head.next = null;
        head = pre;
    }

    public void reverse2() {
        if (head.next == null) {
            return;
        }
        Node<T> newHead = new Node<>();
        Node<T> newTmp = null;

        Node<T> curr = head.next;
        while (curr != null) {
            Node<T> tmp  = curr;
            curr = curr.next;
            tmp.next = newTmp;
            newTmp = tmp;

        }
        newHead.next = newTmp;
        head = newHead;
    }

    public void printSelf() {
        Node<T> tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp.next.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;
    }
}

