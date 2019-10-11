package multithreading.concurrencyTools.locks.reentrantLockCondition;

import multithreading.concurrencyTools.locks.reentrantLockCondition.example.Consumer;
import multithreading.concurrencyTools.locks.reentrantLockCondition.example.Producer;
import multithreading.concurrencyTools.locks.reentrantLockCondition.example.Store;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Application {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        Store store = new Store(reentrantLock, condition);

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
