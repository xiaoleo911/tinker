package test;

import java.awt.Insets;
import java.rmi.server.LoaderHandler;

import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class BinaryTree {
	private Node root;
	public BinaryTree() {
		root = null;
	}

	// 将data插入到排序的二叉树中
	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while(true){//寻找插入位置
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	//将数值输入构建二叉树
	public void buildTree(int[] data){
		for(int i = 0;i < data.length; i++){
			insert(data[i]);
		}
	}
	
	//中序遍历方法递归实现
	public void inOrder(Node localRoot){
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data + "");
			inOrder(localRoot.right);
		}
	}
	
	public void inOrder(){
		this.inOrder(this.root);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree biTree = new BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		biTree.buildTree(data);
		System.out.println("二叉树的中序遍历：");
		biTree.inOrder();
		
	}

}

class Node {
	public int data;
	public Node left;
	public Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}