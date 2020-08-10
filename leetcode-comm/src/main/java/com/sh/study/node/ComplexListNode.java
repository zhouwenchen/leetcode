package com.sh.study.node;

/**  
 * 复杂链表的节点
 * @author zhouwenchen@021.com  
 * @date 2019年6月24日 上午10:30:45 
 */
public class ComplexListNode {
	public int val;
	public ComplexListNode next;
	public ComplexListNode sibling;

	public ComplexListNode(int val) {
		this.val = val;
		this.next = null;
		this.sibling = null;
	}
}
