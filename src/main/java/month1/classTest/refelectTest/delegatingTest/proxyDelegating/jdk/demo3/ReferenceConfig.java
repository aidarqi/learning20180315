package month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo3;

import month1.classTest.refelectTest.delegatingTest.proxyDelegating.jdk.demo2.ProxyFactory;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class ReferenceConfig<T> {

    public Class<?> interfaceClass;
    private transient volatile T ref;
    public synchronized T get() {
        if (null == ref) {
            init();
        }
        return ref;
    }

    private void init() {
        ref = new ProxyFactory(interfaceClass).getProxyObject();
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
