package com.leetcode.lxj.day0812;

import com.leetcode.lxj.dataconstruct.tree.entity.BinaryTree;
import com.leetcode.lxj.dataconstruct.tree.entity.TreeNode;

/**
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * <p>
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * <p>
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点root1 和 root2给出。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 * 解释：我们翻转值为 1，3 以及 5 的三个节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有100个节点。
 * 每棵树中的每个值都是唯一的、在 [0, 99]范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeFlipEquiv {

    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8});
        BinaryTree<Integer> tree2 = new BinaryTree<>(new Integer[]{1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7});

        System.out.println(flipEquiv(tree1.getRootNode(), tree2.getRootNode()));
    }

    public static <T> boolean flipEquiv(TreeNode<T> root1, TreeNode<T> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (!root1.data.equals(root2.data)) {
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
