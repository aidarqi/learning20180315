package month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- before ---");
        Object result = method.invoke(target, args);
        System.out.println("--- end ---");
        return result;
    }

    //生成代理对象
    public Object getProxy() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
//        return Proxy.newProxyInstance(loader, interfaces, this);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
