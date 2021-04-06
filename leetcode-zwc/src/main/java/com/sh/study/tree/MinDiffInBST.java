package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * @author zhouwenchen
 * @date 2021/3/30 16:27
 **/
public class MinDiffInBST {
    /**
     * 中序遍历，并计算两个相邻节点的最小值
     *
     * @param root
     * @return
     */
    public static int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        List<Integer> values = new ArrayList<>();
        while (root != null || !deque.isEmpty()){
            while (root!= null){
                deque.push(root);
                root = root.left;
            }
            root = deque.peek();
            if(!values.isEmpty()){
                result = Math.min(result,root.val-values.get(values.size()-1));
            }
            values.add(root.val);
            deque.pop();
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minDiffInBST(NodeUtil.createTreeNodeByArr(new int[]{4, 2, 6, 1, 3})));
    }
}
