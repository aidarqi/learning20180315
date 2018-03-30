package month1.collectionTest.comparable;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author aidar
 * @desc
 * @date 18-3-20
 */
public class ComparableClassForTest1 {
    public static void main(String[] args) {
        Grand child = new Child();
        Type[] types = child.getClass().getGenericInterfaces();
        if (types != null) {
            for (Type type : types) {
                System.out.println(type.getTypeName());
            }
        }
    }
}

abstract class Grand implements Comparable<Grand>{}
abstract class Super extends Grand implements Serializable{}
class Child extends Super implements Cloneable {
    public int compareTo(Grand o) {
        return 0;
    }
}
