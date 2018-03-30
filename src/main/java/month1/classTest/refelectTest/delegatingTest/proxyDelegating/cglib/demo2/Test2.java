package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class Test2 {
    public static void main(String[] args) {
        BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三"));
        service.query();
        service.create();
        BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("李四"));
        service2.create();
        service2.query();
    }
}
