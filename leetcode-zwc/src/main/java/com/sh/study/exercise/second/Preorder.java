package com.sh.study.exercise.second;

import com.sh.study.node.ListNode;
import com.sh.study.node.Node;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *          1
 *      3          2       4
 * 5        6
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @Author zhouwenchen
 * @Data 2020/8/14/14
 **/
public class Preorder {

    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            if(node.children != null){
                Collections.reverse(node.children);
                for(Node item:node.children){
                    stack.add(item);
                }
            }
        }
        return result;
    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public static List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
       Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if(node.children != null){
                // 因为放入的是栈中，所有需要将node的子节点反转一下
                Collections.reverse(node.children);
                for(Node item:node.children){
                    stack.add(item);
                }
            }
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

        List<Integer> result = preorder2(node1);
        result.stream().forEach(o-> System.out.print(o + "\t"));
    }
}
