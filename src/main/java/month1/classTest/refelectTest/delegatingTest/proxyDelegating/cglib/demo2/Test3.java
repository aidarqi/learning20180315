package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class Test3 {
    public static void main(String[] args) {
        BookServiceBean service = BookServiceFactory3.getProxyInstance(new MyCglibProxy3("张三"));
        service.query();
        service.create();
        BookServiceBean service2 = BookServiceFactory3.getProxyInstance(new MyCglibProxy3("张"));
        service2.create();
        service2.query();
    }
}
