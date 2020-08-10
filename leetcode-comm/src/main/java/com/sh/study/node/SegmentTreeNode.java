package com.sh.study.node;

/**  
 * 线段树节点 SegmentTreeNode
 * @author zhouwenchen@021.com  
 * @date 2019年6月11日 下午2:09:54 
 */
public class SegmentTreeNode {
	public int start, end;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end) {
	         this.start = start;
	         this.end = end;
	         this.left = this.right = null;
	     }
}
