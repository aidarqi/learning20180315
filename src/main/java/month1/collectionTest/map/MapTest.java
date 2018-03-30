package month1.collectionTest.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author aidar
 * @desc
 * @date 18-3-19
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i =0 ; i < 100; i++) {
            map.put(i,String.valueOf(i));
        }
//        map.put(2, "b");
        System.out.println(map);
//        System.out.println(map.get(1));
//        LinkedHashMap map1 = new LinkedHashMap();
//        map1.put(1, "a");
    }

}
