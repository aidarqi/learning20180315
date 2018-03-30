package month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class ProxyFactory implements InvocationHandler {
    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    //返回代理对象,此处用泛型是为了调用时不用强转,用Object需要强转
    public <T> T getProxyObject() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{interfaceClass}, this);
    }
    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        System.out.println("进行编码");
        System.out.println("发送网络请求");
        System.out.println("将网络请求结果进行解码并返回");
        return null;
    }
}
