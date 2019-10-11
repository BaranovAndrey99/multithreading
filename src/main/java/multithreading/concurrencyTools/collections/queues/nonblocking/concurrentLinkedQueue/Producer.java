package multithreading.concurrencyTools.collections.queues.nonblocking.concurrentLinkedQueue;

public class Producer implements Runnable {
    private Products products;

    public Producer(Products products) {
        this.products = products;
    }

    @Override
    public void run() {
        products.setProducerActivity();
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println("Producer add product");
                products.addElement("Product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.unsetProducerActivity();
    }
}
