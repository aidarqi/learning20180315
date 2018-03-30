package month1.classLoaderTest;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class Const {
    static int A = 100;
    static {
        System.out.println("Const init");
    }
}
