package multithreading.concurrencyTools.collections.queues.nonblocking.concurrentLinkedQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Products {
    private Queue<String> queue;
    //private LinkedList<String> queue;

    private boolean producerActivity = true;

    public Products() {
        this.queue = new ConcurrentLinkedQueue<>();
        //this.queue = new LinkedList<>();
    }

    public boolean isProducerActivity() {
        return this.producerActivity;
    }

    public void setProducerActivity() {
        this.producerActivity = true;
    }

    public void unsetProducerActivity() {
        this.producerActivity = false;
    }
    // LinkedList<String>
    // Queue<String>
    public Queue<String> getQueue() {
        return queue;
    }

    public void addElement(String element) throws InterruptedException {
        this.queue.add(element);
        Thread.sleep(100);
    }

    public void buyProduct() throws InterruptedException {
        this.queue.poll();
        Thread.sleep(10);
    }
}
