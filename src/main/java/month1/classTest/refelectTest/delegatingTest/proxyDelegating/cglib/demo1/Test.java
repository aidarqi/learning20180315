package month1.classTest.refelectTest.delegatingTest.proxyDelegating.cglib.demo1;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class Test {
    public static void main(String[] args) {
        BookFacadeImpl1 bookFacadeImpl1 = new BookFacadeImpl1();
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl1 bookCglib = (BookFacadeImpl1) cglib.getInstance(bookFacadeImpl1);
        bookCglib.addBook();
        bookCglib.delBook();
    }
}
