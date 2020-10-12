package algorithm.lru;

import java.util.HashMap;

/**
 * LRU 手写版本
 * 参考：https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195947&idx=1&sn=2954871ed1195dd3ebab0c9691e674b4&chksm=8c99fc71bbee7567c29169a86b4a2133bf87492ce5d2b7c9fdaf7740d2fc01084670b75e976a&mpshare=1&scene=1&srcid=1011WIeXmbosts9LeJppauI5&sharer_sharetime=1602465044402&sharer_shareid=b4762e7b656d2d716d9486ef50358d45&version=3.0.31.2998&platform=win&rd2werd=1#wechat_redirect
 *
 * @author: fupeng
 * @date: 2020/10/12 9:07
 */
public class LRUCache<K, V> {

    private Node head;
    private Node tail;
    // 缓存存储上限
    private int cacheSize;
    private HashMap<String, Node> hashMap;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        hashMap = new HashMap<String, Node>();
    }

    public synchronized void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            // node 不存在，插入key-value
            if (hashMap.size() >= cacheSize) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            // key 存在，刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    public synchronized String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        // 调整Node链表顺序
        refreshNode(node);
        return node.value;
    }

    /**
     * 刷新被访问Node的位置
     *
     * @param node
     */
    private synchronized void refreshNode(Node node) {
        // 如果是尾结点，不用调整
        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.next;
        }
        // 移除节点
        removeNode(node);
        // 重新插入节点
        addNode(node);
    }

    private String removeNode(Node node) {
        if (node == tail && hashMap.size() == 1) {
            head = null;
            tail = null;
        } else if (node == tail) {
            tail = tail.pre;
        } else if (node == head) {
            // 移除头节点
            head = head.next;
        } else {
            // 移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    private void addNode(Node node) {
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
            node.next = null;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public class Node {

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        private Node pre;
        private Node next;
        private String key;
        private String value;

    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
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

        lru = new LRUCache(1);
        lru.put("1", "1");

        System.out.println("==========================================");
        lru.printLRU();
        System.out.println();
        lru.put("4", "4");
        lru.printLRU();
        System.out.println();
        System.out.println("head should be 2");
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
