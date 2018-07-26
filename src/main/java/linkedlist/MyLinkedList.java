package linkedlist;

import java.util.Random;

public class MyLinkedList {
	Node head = null;
	
	/*
	 * add
	 */
	public void add(int data){
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = node;
	}
	
	/*
	 * remove
	 */
	public Boolean remove(int index){
		if (index == 0) {
			return false;
		}
		if (index == 1) {
			head = head.next;
			return true;
		}
		int count = 2;
		Node preNode = head;
		Node current = head.next;
		while(index != count){
			preNode = current;
			current = current.next;
			count++;
		}
		if (index == count) {
			preNode.next = current.next;
		}
		return true;
	}
	
	/*
	 * length
	 */
	public int length(){
		int length = 0;
		if (head == null) {
			return 0;
		}
		Node node = head;
		while(node != null){
			node = node.next;
			length++;
		}
		return length;
	}
	
	/*
	 * 排序
	 */
	public void orderList(){
		int temp = 0;
		Node preNode = head;
		if (preNode == null) {
			return;
		}
		Node current = head.next;
		while(preNode != null){
			current = preNode.next;
			while(current != null){
				if (preNode.data > current.data) {
					temp = preNode.data;
					preNode.data = current.data;
					current.data = temp;
				}
				current = current.next;
			}
			preNode = preNode.next;
		}
	}
	
	/*
	 * 打印
	 */
	public void printList(){
		if (head == null) {
			return;
		}
		Node node = head;
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	/*
	 * 输出倒数第k个数
	 * 倒数第5个
	 */
	public int findElement1(MyLinkedList list){
		int length = list.length();
		int index = length - 4;
		int count = 1;
		Node node = list.head;
		while(count != index){
			node = node.next;
			count++;
		}
		return node.data;
	}
	
	/*
	 * 输出倒数第k个数
	 * 倒数第5个
	 */
	public int findElement2(MyLinkedList list){
		Node p1 = list.head;
		Node p2 = list.head;
		for(int i = 0; i < 5 ; i++){
			p1 = p1.next;
		}
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;
	}
	
	
	public static void main(String args[]){
//		MyLinkedList list = new MyLinkedList();
//		list.add(5);
//		list.add(3);
//		list.add(1);
//		list.add(3);
//		System.out.println("ListLen:  "+list.length());
//		System.out.println("before order:");
//		list.printList();
//		list.orderList();
//		System.out.println("after order:");
//		list.printList();
//		System.out.println("before remove:");
//		list.printList();
//		list.remove(1);
//		System.out.println("after remove:");
//		list.printList();
		
		MyLinkedList list = new MyLinkedList();
		Random r = new Random();
		for(int i = 0;i < 100000;i++){
			list.add(r.nextInt(10));
		}
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println("begin");
		System.out.println("=================================================================");
		long start = System.currentTimeMillis();
		int result = list.findElement1(list);
		long stop =  System.currentTimeMillis();
		System.out.println("倒数第五个数为：" + result + "    method1执行时间：" + (stop - start));
		
		start =  System.currentTimeMillis();
		result = list.findElement2(list);
		stop =  System.currentTimeMillis();
		System.out.println("倒数第五个数为：" + result + "    method2执行时间：" + (stop - start));
		
		

	}
	
}
