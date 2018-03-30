package month1.classTest.refelectTest.delegatingTest.staticDelegating;

/**
 * @author aidar
 * @desc 静态代理实现中，一个委托类对应一个代理类，代理类在编译期间就已经确定。
 * @date 18-3-22
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }
}
