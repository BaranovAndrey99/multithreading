package multithreading.concurrencyTools.collections.queues.blocking.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataStream {
    private BlockingQueue<String> queue;
    private boolean allDataHandled;

    private final String[]  dataExample = {
            "Part 1",
            "Part 2",
            "Part 3",
            "Part 4"
    };

    public DataStream() {
        this.queue = new ArrayBlockingQueue<>(1);
        this.allDataHandled = false;
    }

    public BlockingQueue<String> getQueue() {
        return this.queue;
    }

    public void putQueueElement(String element) throws InterruptedException {
        this.queue.put(element);
        System.out.println(element + " produce");
    }

    public void takeQueueElement() throws InterruptedException {
        String msg = this.queue.take();
        System.out.println(msg + " get");
    }

    public boolean isAllDataHandled() {
        return this.allDataHandled;
    }

    public void setAllDataHandled() {
        this.allDataHandled = true;
    }

    public String[] getDataExample() {
        return this.dataExample;
    }

    public boolean queueIsEmpty() {
        return this.queue.isEmpty();
    }
}
