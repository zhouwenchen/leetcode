package com.sh.study.exercise.every.ten;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 284. 顶端迭代器
 * 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
 *
 * 实现 PeekingIterator 类：
 *
 * PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
 * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * int peek() 返回数组中的下一个元素，但 不 移动指针。
 *
 *
 * 示例：
 *
 * 输入：
 * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出：
 * [null, 1, 2, 2, 3, false]
 *
 * 解释：
 * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 * peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
 * peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
 * peekingIterator.hasNext(); // 返回 False
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 对 next 和 peek 的调用均有效
 * next、hasNext 和 peek 最多调用  1000 次
 */
public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	private Integer nextElement;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		nextElement = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ret = this.nextElement;
		this.nextElement = iterator.hasNext() ? iterator.next() : null;
		return ret;
	}
	
	@Override
	public boolean hasNext() {
	    return nextElement != null;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		PeekingIterator peekingIterator = new PeekingIterator(list.iterator()); // [1,2,3]
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.hasNext());
	}
}