package multithreading.concurrencyTools.collections.queues.nonblocking.concurrentLinkedQueue;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Products products = new Products();

        Producer producer = new Producer(products);
        Consumer consumer = new Consumer(products);

        Thread thread1 = new Thread(producer, "ProducerThread");
        Thread thread2 = new Thread(consumer, "ConsumerThread");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        if(products.getQueue().isEmpty()) {
            System.out.println("Products successfully sold!");
        }
    }
}
