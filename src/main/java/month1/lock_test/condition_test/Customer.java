package month1.lock_test.condition_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-30
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot =depot;
    }

    public void consume(final int value) {
        new Thread(){
            @Override public void run() {
                depot.get(value);
            }
        }.start();
    }
}
