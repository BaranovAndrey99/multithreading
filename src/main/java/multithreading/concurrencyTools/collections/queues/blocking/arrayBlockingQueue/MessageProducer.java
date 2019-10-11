package multithreading.concurrencyTools.collections.queues.blocking.arrayBlockingQueue;

public class MessageProducer implements Runnable {
    private DataStream dataStream;

    public MessageProducer(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void run() {
        String[] data = dataStream.getDataExample();
        for (int i = 0; i < data.length; i++) {
            try {
                dataStream.putQueueElement(data[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dataStream.setAllDataHandled();
    }
}
