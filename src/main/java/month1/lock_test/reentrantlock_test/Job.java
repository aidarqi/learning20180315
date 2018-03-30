package month1.lock_test.reentrantlock_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + ": Going to print a document");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + ": The document has been printed\n");

    }
}
