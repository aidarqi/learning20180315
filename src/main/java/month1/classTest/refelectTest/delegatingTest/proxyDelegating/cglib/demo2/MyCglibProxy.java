package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class MyCglibProxy implements MethodInterceptor {

    private String name;

    public MyCglibProxy(String name) {
        this.name = name;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
        throws Throwable {
        System.out.println("调用的方法是: " + method.getName());
        System.out.println("实际调用者是: " + obj.getClass());
        for (Object arg : args) {
            System.out.println("方法参数类型为: " + obj.getClass());
        }
        if (!name.equals("张三")) {
            System.out.println("权限不够");
            return null;
        }
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("这是方法后...");
        return result;
    }
}
