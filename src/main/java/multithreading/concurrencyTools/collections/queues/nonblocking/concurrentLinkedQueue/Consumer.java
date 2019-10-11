package multithreading.concurrencyTools.collections.queues.nonblocking.concurrentLinkedQueue;

public class Consumer implements Runnable {
    private Products products;

    public Consumer(Products products) {
        this.products = products;
    }

    @Override
    public void run() {
        while (this.products.isProducerActivity() || this.products.getQueue().size() > 0) {
            try {
                if(this.products.getQueue().size() != 0) {
                    System.out.println("Consumer buy product");
                    this.products.buyProduct();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
