package month1.concurrency_collection_test.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author aidar
 * @desc
 * @date 18-3-26
 */
public class HashMapTest {

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<>(2);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
        System.out.println(map.size());
    }
}
