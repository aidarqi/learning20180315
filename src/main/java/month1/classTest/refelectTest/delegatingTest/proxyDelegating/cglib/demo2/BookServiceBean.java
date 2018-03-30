package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class BookServiceBean {

    public BookServiceBean() {
        System.out.println("This is BookServiceBean 的构造方法");
    }

    public void create() {
        System.out.println("create ... ");
    }

    public void query() {
        System.out.println("query ... ");
    }
}
