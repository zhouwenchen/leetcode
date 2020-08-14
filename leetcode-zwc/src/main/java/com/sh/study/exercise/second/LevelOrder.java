package com.sh.study.exercise.second;

import com.sh.study.node.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *          1
 *      3          2       4
 * 5        6
 * <p>
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * @Author zhouwenchen
 * @Data 2020/8/14/17
 **/
public class LevelOrder {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                Node node = queue.poll();
                list.add(node.val);
                if(node.children != null){
                    for (Node item: node.children){
                        queue.add(item);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Node> children = new ArrayList<>();
        Node node3 = new Node(3);
        children.add(node3);
        children.add(new Node(2));
        children.add(new Node(4));

        List<Node> node3_children = new ArrayList<>();
        node3_children.add(new Node(5) );
        node3_children.add(new Node(6) );
        node3.children = node3_children;
        Node node1 = new Node(1,children);

        List<List<Integer>> result = levelOrder(node1);
        result.stream().forEach(o-> System.out.print(o + "\t"));
    }
}
