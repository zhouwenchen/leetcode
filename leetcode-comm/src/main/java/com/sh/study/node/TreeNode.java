package com.sh.study.node;

/**  
 * 树的节点 信息
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}