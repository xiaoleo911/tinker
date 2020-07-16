package algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: fupeng
 * time: 2020-07-17 6:41
 */
public class LRU<K, V> extends LinkedHashMap<K, V>{

    private int cacheSize;

    public LRU(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.put("4", 4);

        lru.printLRU(lru);

        System.out.println();
        lru.get("3");

        lru.printLRU(lru);

    }

    public void printLRU(LRU lru) {
        Iterator<Map.Entry<String, Integer>> iterator = lru.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }


}
