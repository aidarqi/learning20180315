package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class MyProxyFilter implements CallbackFilter {
    @Override public int accept(Method method) {
        if (!"query".equalsIgnoreCase(method.getName())) {
            return 0;
        }
        return 1;
    }
}
