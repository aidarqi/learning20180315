package month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo1;

/**
 * @author aidar
 * @desc 动态代理中，代理类并不是在Java代码中实现，而是在运行时期生成，
 *       相比静态代理，动态代理可以很方便的对委托类的方法进行统一处理，如添加方法调用次数、添加日志功能等等
 *       以下示例为jdk动态代理
 * @date 18-3-22
 */
public class ProxyTest {
    public static void main(String[] args) {
        Service service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        Service serviceProxy = (Service)handler.getProxy();
        serviceProxy.add();
    }
}
