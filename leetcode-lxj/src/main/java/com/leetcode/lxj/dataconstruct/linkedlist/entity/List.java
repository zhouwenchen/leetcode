package com.leetcode.lxj.dataconstruct.linkedlist.entity;

public interface List<T> {

    void add(T t);

    T remove(T t);

    T find(T t);

    int size();

    void printSelf();
}
