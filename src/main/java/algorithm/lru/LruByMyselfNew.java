package algorithm.lru;

import java.util.HashMap;

/**
 * LRU 自己写的版本
 *
 * @author: fupeng
 * @date: 2020/10/14 10：00
 */
public class LruByMyselfNew {

    private Node head;
    private Node tail;
    private int cacheSize;
    private HashMap<String, Node> hashMap;

    public LruByMyselfNew(int cacheSize) {
        this.cacheSize = cacheSize;
        hashMap = new HashMap<>();
    }

    public synchronized void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() >= cacheSize) {
                hashMap.remove(head.key);
                if (hashMap.size() == 0) {
                    head = tail = null;
                } else {
                    head = head.next;
                }
            }
            Node newNode = new Node(key, value);
            hashMap.put(key, newNode);
            addNode(newNode);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    public synchronized String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        } else {
            refreshNode(node);
            return node.value;
        }
    }

    private void addNode(Node node) {
        if (head == null && tail == null) {
            head = tail = node;
            return;
        }
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
        }
        tail = node;
        tail.next = null;
    }

    private void refreshNode(Node node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = head.next;
            addNode(node);
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addNode(node);
    }

    public class Node {
        private Node pre;
        private Node next;
        private String key;
        private String value;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }



    public static void main(String[] args) {
        LruByMyselfNew lru = new LruByMyselfNew(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("4", "4");

        lru.printLRU();
        System.out.println();
        lru.get("2");
        lru.printLRU();
        System.out.println();
        System.out.println("head should be 3");

        System.out.println("==========================================");
        lru = new LruByMyselfNew(3);
        lru.put("1", "1");
        lru.put("1", "2");
        lru.put("3", "3");

        lru.printLRU();
        System.out.println();
        lru.get("1");
        lru.printLRU();
        System.out.println();
        System.out.println("head should be 3");


        System.out.println("==========================================");
        lru = new LruByMyselfNew(1);
        lru.put("1", "1");

        lru.printLRU();
        System.out.println();
        lru.put("4", "4");
        lru.printLRU();
        System.out.println();
        System.out.println("head should be 4");
    }

    public void printLRU() {
        if (head != null) {
            Node node = head;
            while (node != null) {
                System.out.println("key = " + node.key + ", value = " + node.value);
                node = node.next;
            }
        }
    }

}
