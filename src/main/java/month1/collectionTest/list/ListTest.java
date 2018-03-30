package month1.collectionTest.list;

import java.util.*;

/**
 * @author aidar
 * @desc
 * @date 18-3-19
 */
public class ListTest {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        List list1 = new LinkedList();
        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list1.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(list.contains(8888));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        long start3 = System.currentTimeMillis();
        System.out.println(list1.contains(8888));
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);

        long start4 = System.currentTimeMillis();
        System.out.println(list.get(1999));
        long end4 = System.currentTimeMillis();
        System.out.println(end4 - start4);

        long start5 = System.currentTimeMillis();
        System.out.println(list1.get(1999));
        long end5 = System.currentTimeMillis();
        System.out.println(end5 - start5);

        List list2 = new LinkedList();
        list2.add(null);
        list2.add( null);
        list2.add( null);
        list2.add( null);
        System.out.println(list2.size());
        list2.remove(null);
        System.out.println(list2.size());


    }
}