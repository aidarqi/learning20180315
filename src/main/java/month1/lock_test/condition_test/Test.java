package month1.lock_test.condition_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-30
 */
public class Test {
    public static void main(String[] args) {
        Depot depot = new Depot(15);

        Producer producer = new Producer(depot);
        Customer customer = new Customer(depot);

        producer.produce(10);
        customer.consume(5);
        producer.produce(20);
        customer.consume(35);
        customer.consume(35);
    }
}
