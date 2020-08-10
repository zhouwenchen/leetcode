package com.sh.study.node;

/**  
 * 二叉树，左右子树，包括父节点
 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 下午5:04:57 
 */
public class BinaryTreeNode {
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode parent;

	public BinaryTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}