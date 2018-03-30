package month1.collectionTest.comparable;

/**
 * @author aidar
 * @desc
 * @date 18-3-20
 */
public class ComparableClassForTest {
    public static void main(String[] args) {
        D d = new D();
        System.out.println(new A(){}.getClass());   // class Demo$1
        System.out.println(new B(){}.getClass());   // class Demo$2
        System.out.println(new Comparable<Object>(){    // class Demo$3
            @Override
            public int compareTo(Object o) {
                return 0;
            }}.getClass());
        System.out.println(d.c.getClass()); // class D$1
    }
}

abstract class A{}
abstract class B{}
abstract class C{}
class D{
    C c;
    D(){
        c= new C(){};
    }
}
