package multithreading.concurrencyTools.collections.queues.blocking.arrayBlockingQueue;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        DataStream dataStream = new DataStream();

        MessageProducer messageProducer = new MessageProducer(dataStream);
        MessageConsumer messageConsumer = new MessageConsumer(dataStream);

        Thread thread1 = new Thread(messageProducer, "ProducerThread");
        Thread thread2 = new Thread(messageConsumer, "ConsumerThread");

        thread2.start();
        Thread.sleep(1000);
        thread1.start();

        thread1.join();
        thread2.join();

        if(dataStream.getQueue().isEmpty()) {
            System.out.println("All data handled");
        }
    }
}
