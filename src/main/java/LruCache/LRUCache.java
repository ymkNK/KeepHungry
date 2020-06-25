package LruCache;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ymkNK on 2020-05-06.
 */
public class LRUCache {

    private int capacity;
    private HashMap<Integer, Integer> cache;
    private List<Integer> lruStack;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.lruStack = new ArrayList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 将这个数字移动到栈顶
            lruStack.remove((Integer) key);
            lruStack.add(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            lruStack.removeIf(integer -> integer.equals(key));
            lruStack.add(key);
            return;
        }
        if (lruStack.size() < capacity) {
            lruStack.removeIf(integer -> integer.equals(key));
            lruStack.add(key);
            cache.put(key, value);
        } else {
            Integer toDelete = lruStack.get(0);
            cache.remove(toDelete);
            lruStack.remove(0);
            put(key, value);
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }
}
