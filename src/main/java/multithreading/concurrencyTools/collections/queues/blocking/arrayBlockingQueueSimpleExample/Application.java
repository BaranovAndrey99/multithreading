package multithreading.concurrencyTools.collections.queues.blocking.arrayBlockingQueueSimpleExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        AtomicBoolean allDataHandled = new AtomicBoolean(false);

        String[] data = {
                "Part 1",
                "Part 2",
                "Part 3",
                "Part 4"
        };

        Runnable produce = () -> {
            for (int i = 0; i < data.length; i++) {
                try {

                    queue.put(data[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            allDataHandled.set(true);
        };

        Runnable consume = () -> {
            while (!allDataHandled.get() || !queue.isEmpty()) {
                String element;
                try {
                    queue.take();
                    //System.out.println(queue.take() + " TAKE");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producer = new Thread(produce, "Producer");
        Thread consumer = new Thread(consume, "Consumer");

        consumer.start();
        Thread.sleep(1000);
        producer.start();

        producer.join();
        consumer.join();

        if(queue.isEmpty()) {
            System.out.println("All data handled");
        }
    }
}
