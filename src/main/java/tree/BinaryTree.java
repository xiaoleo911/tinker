package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

/**
 * 中序、先序、后续、层序遍历二叉树
 * <p>
 * author: fupeng
 * time: 2020-07-11 15:02
 */
public class BinaryTree {

    /*
   二叉树结构
            2
           / \
         1     8
              / \
             7   9
            / \
           4   7
          / \
         3   6
            /
           5
     */
    public static void main(String[] args) {
        BinaryTree biTree = new BinaryTree();
        int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
        biTree.buildTree(data);
        System.out.println("二叉树的中序遍历：");
        biTree.inOrder();
        System.out.println();

        System.out.println("二叉树的先序遍历：");
        biTree.preOrder();
        System.out.println();

        System.out.println("二叉树的后序遍历：");
        biTree.postOrder();
        System.out.println();

        System.out.println("层序遍历二叉树：");
        biTree.layerTranverse();


        System.out.println("工字遍历二叉树：");
        ArrayList<ArrayList<Integer>> list = biTree.zLevelOrder(biTree.root);
        list.forEach(list1 -> System.out.println(list1));

    }

    private ArrayList<ArrayList<Integer>> zLevelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = null;
                if (depth % 2 == 0) {
                    node = queue.pollLast();
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                } else {
                    node = queue.poll();
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                tmp.add(node.data);
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }


    /**
     * 二叉树
     */
    private Node root;

    private BinaryTree() {
        this.root = null;
    }

    /**
     * 将数值输入构建二叉树
     *
     * @param data
     */
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    /**
     * 将data插入到排序二叉树中
     *
     * @param data
     */
    private void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            // 寻找插入的位置
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历方法递归实现  左子节点 -> root -> 右子节点
     *
     * @param localRoot
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            out.print(localRoot.data + "");
            inOrder(localRoot.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    /**
     * 先序遍历方法递归实现  root -> 左子节点 -> 右子节点
     *
     * @param localRoot
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            out.print(localRoot.data + "");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    /**
     * 后序遍历方法递归实现  左子节点 -> 右子节点 -> root
     *
     * @param localRoot
     */
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            out.print(localRoot.data + "");
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    /**
     * 层序遍历二叉树
     */
    public void layerTranverse() {
        if (this.root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            out.print(n.data);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }

    /**
     * node 节点
     */
    public class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
