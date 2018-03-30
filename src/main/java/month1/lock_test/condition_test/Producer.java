package month1.lock_test.condition_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-30
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int value) {
        new Thread() {
            @Override public void run() {
                depot.put(value);
            }
        }.start();
    }
}
