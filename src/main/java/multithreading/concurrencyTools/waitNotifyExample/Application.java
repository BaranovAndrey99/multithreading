package multithreading.concurrencyTools.waitNotifyExample;

import multithreading.concurrencyTools.waitNotifyExample.example.Consumer;
import multithreading.concurrencyTools.waitNotifyExample.example.Producer;
import multithreading.concurrencyTools.waitNotifyExample.example.Store;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
