package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class BookServiceFactory {
    private BookServiceFactory() {

    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
        Enhancer enhancer = new Enhancer();
        //将Enhancer中的superclass属性赋值为BookServiceBean
        enhancer.setSuperclass(BookServiceBean.class);
        //将Enhancer中的callbacks属性赋值为myProxy
//        enhancer.setCallback(myProxy);
        enhancer.setCallbacks(new Callback[] {myProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new MyProxyFilter());
        return (BookServiceBean)enhancer.create();
    }
}
