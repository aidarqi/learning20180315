package month1.classTest.refelectTest.delegatingTest.staticDelegating;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class RealSubject implements Subject {
    @Override public void request() {
        System.out.println("RealSubject...");
    }
}
