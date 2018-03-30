package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        //创建加强器,用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类(即:为下面生成的代理类指定父类)
        enhancer.setSuperclass(this.target.getClass());
        //设置回调:对于代理类上所有方法的调用,都会调用CallBack,而CallBack则需要实现interrupt()方法拦截
        enhancer.setCallback(this);
        //创建动态代理类对象并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
        throws Throwable {
        System.out.println("start...");
        proxy.invokeSuper(obj, args);
        System.out.println("after...");
        return null;
    }
}
