package com.leetcode.lxj.dataconstruct.linkedlist.entity;

public class LinkedList<T> implements List<T> {
    private final Node<T> head = new Node<>();
    private Node<T> foot = head;
    private int size = 0;

    @Override
    public void add(T t) {
        size++;
    }

    @Override
    public T remove(T t) {
        return null;
    }

    @Override
    public T find(T t) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printSelf() {

    }

    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> pre;
    }
}