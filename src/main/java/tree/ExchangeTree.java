package tree;

/**
 * 交换二叉树左右节点
 * author: fupeng
 * time: 2020-06-25 19:41
 */
public class ExchangeTree {

    // 初始二叉树
    /*     1
        4     2
          5  3  6
                  7*/
    // 左右节点交换之后的二叉树
    /*     1
        2     4
      6   3  5
    7*/

    public static void main(String[] args) {
        ExchangeTree exchangeTree = new ExchangeTree();
        exchangeTree.exchageTree();
    }

    public void exchageTree() {
        Node head = new Node();
        head.data = 1;// 根节点赋初值
        makeTree(head);// 构造一棵二叉树

        System.out.println("交换之\n==============");
        // 中序遍历打印二叉树
        inOrderVisit(head);

        // 中序遍历 + 递归计算
        exchageTree(head);

        System.out.println("\n");
        System.out.println("交换之后\n==============");
        // 中序遍历打印二叉树
        inOrderVisit(head);
    }

    /**
     * 中序遍历打印二叉树
     *
     * @param root
     */
    public static void inOrderVisit(Node root) {
        if (root == null) {
            return;
        }
        inOrderVisit(root.left);
        System.out.print(root.data);
        inOrderVisit(root.right);
    }

    /**
     * 交换二叉树
     *
     * @param head
     */
    public void exchageTree(Node head) {
        if (head == null) return;
        if (head.left != null || head.right != null) {
            Node temp = head.left;
            head.left = head.right;
            head.right = temp;
        } else {
            return;
        }
        exchageTree(head.left);
        exchageTree(head.right);
    }

    public void makeTree(Node head) {
        /*    1
           4     2
             5  3  6
                     7*/
        Node node4 = new Node();
        node4.data = 4;
        node4.parent = head;
        head.left = node4;
        Node node5 = new Node();
        node5.data = 5;
        node5.parent = node4;
        node4.right = node5;
        Node node2 = new Node();
        node2.data = 2;
        head.right = node2;
        node2.parent = head;
        Node node3 = new Node();
        node3.data = 3;
        node3.parent = node2;
        node2.left = node3;
        Node node6 = new Node();
        node6.data = 6;
        node6.parent = node2;
        node2.right = node6;
        Node node7 = new Node();
        node7.data = 7;
        node7.parent = node6;
        node6.right = node7;
    }

    /**
     * 定义二叉树的父节点，左右子节点，数据节点
     */
    class Node {
        Node parent = null;
        Node left = null;
        Node right = null;
        Object data = null;
    }


}
