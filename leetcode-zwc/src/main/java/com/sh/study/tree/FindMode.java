package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @Author zhouwenchen
 * @Date  2020-09-24
 **/
public class FindMode {

    /**
     * 思路1：中序遍历，可以获取到排好序的数组
     * @param root
     * @return
     */
    public static Map<Integer,Integer> map = new HashMap<>();
    public static int max = 0;
    public static int[] findMode(TreeNode root) {
        List<Integer> list2 = new ArrayList<>();
        dfs(root);
        // map 遍历获取到最大的值
        Set<Integer> keys = map.keySet();
        int[] result = new int[keys.size()];
        List<List<Integer>> listList = keys.stream().map((key) -> {
            if (max == map.get(key)) {
                list2.add(key);
            }
            return list2;
        }).collect(Collectors.toList());

        //
        return list2.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 中序遍历
     */
    private static void dfs(TreeNode root) {
        if(root != null){
            dfs(root.left);
            // 判断
            if(map.containsKey(root.val)){
                max =Math.max(max,map.get(root.val) + 1);
                map.put(root.val,map.get(root.val)+1);
            } else {
                map.put(root.val,1);
                max = Math.max(max,1);
            }
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
//        int[] mode = findMode(NodeUtil.createTreeNodeByArr(new int[]{5, 3, 7, 2, 4, 6, 7}));
//        int[] mode = findMode(NodeUtil.createTreeNodeByArr(new int[]{5, 3, 7, 2, 3, 6, 7}));
        int[] mode = findMode(NodeUtil.createTreeNodeByArr(new int[]{5}));
        Arrays.stream(mode).forEach(System.out::println);

    }
}
