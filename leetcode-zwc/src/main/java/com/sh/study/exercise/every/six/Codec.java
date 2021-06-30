package com.sh.study.exercise.every.six;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *
 *
 * 示例：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 *
 * @author zhouwenchen
 * @date 2021/6/30 17:49
 **/
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    private static String rserialize(TreeNode root, String str) {
        if(root == null){
            str += "null,";
        }else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(dataArray));

        return rdeserialize(dataList);
    }

    private static TreeNode rdeserialize(LinkedList<String> dataList) {
        if(dataList.get(0).equals("null")){
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5, 6, 7});
        String result = serialize(root);
        System.out.println("result:\t" + result);

        TreeNode deserialize = deserialize(result);
        NodeUtil.printTreeNodeByLevelOrder(deserialize);
    }
}
