package month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo2;

import month1.classTest.refelectTest.delegatingTest.staticDelegating.Proxy;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class Test {
    public static void main(String[] args) {
//        MenuService service = new MenuServiceImpl();
//        ProxyFactory factory = new ProxyFactory(service.getClass());
//        MenuService service1 = factory.getProxyObject();
//        service1.sayHello();

        ProxyFactory factory = new ProxyFactory(MenuService.class);
        MenuService service = factory.getProxyObject();
        service.sayHello();

    }
}
