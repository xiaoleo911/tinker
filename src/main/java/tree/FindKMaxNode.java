package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉排序树寻找第k大的数
 *
 * author: fupeng
 * time: 2020-10-25 23:03
 */
public class FindKMaxNode {


    private static List<Integer> list = new ArrayList<>();

    /**
     *
     * @param root  根节点
     * @return
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            inOrder(root.right);
        }
        list.add(root.data);
        if (root.left != null) {
            inOrder(root.left);
        }
    }

    /**
     *
     *           3
     *       1      4
     *         2       6
     *               5
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(3);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.left = node1;
        root.right = node4;
        node1.right = node2;
        node4.right = node6;
        node6.left = node5;
        inOrder(root);
        int k = 2;
        System.out.println("it shoule be 5");
        System.out.println(list.get(k - 1));
    }

    public static class Node {
        private Node left;
        private Node right;
        private int data;

        public Node (int data) {
            this.data = data;
        }
    }
}
