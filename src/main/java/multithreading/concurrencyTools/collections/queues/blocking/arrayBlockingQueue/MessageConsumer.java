package multithreading.concurrencyTools.collections.queues.blocking.arrayBlockingQueue;

public class MessageConsumer implements Runnable {
    private DataStream dataStream;

    public MessageConsumer(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void run() {
        while (!dataStream.isAllDataHandled() || !dataStream.queueIsEmpty()) {
            try {
                dataStream.takeQueueElement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
