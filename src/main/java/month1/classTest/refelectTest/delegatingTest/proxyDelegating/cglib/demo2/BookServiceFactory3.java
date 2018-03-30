package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author aidar
 * @desc
 * @date 18-3-23
 */
public class BookServiceFactory3 {
    private BookServiceFactory3() {

    }

    public static BookServiceBean getProxyInstance(MyCglibProxy3 myProxy) {
        Enhancer enhancer = new Enhancer();
        //将Enhancer中的superclass属性赋值为BookServiceBean
        enhancer.setSuperclass(BookServiceBean.class);
        //将Enhancer中的callbacks属性赋值为myProxy
        enhancer.setCallback(myProxy);
        return (BookServiceBean)enhancer.create();
    }
}
