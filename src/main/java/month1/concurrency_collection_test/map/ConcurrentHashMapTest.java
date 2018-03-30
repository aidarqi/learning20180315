package month1.concurrency_collection_test.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author aidar
 * @desc
 * @date 18-3-26
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1,"a");
    }
}
