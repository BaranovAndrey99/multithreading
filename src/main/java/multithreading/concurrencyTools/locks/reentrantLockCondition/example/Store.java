package multithreading.concurrencyTools.locks.reentrantLockCondition.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int productNum = 0;
    private ReentrantLock reentrantLock;
    private Condition condition;

    public Store(ReentrantLock reentrantLock, Condition condition) {
        this.reentrantLock = reentrantLock;
        this.condition = condition;
    }

    /**
     * Если товаров на скалде нет, то поток на покупку ожидает, освободив монитор.
     * @throws InterruptedException - исключение.
     */
    public void get() throws InterruptedException {
        //synchronized
        reentrantLock.lock();

        if(productNum < 1) {
            //wait();
            condition.await();
        }
        productNum--;
        System.out.println("Покупатель приобрел 1 товар.");
        System.out.println("Товаров на складе: " + productNum);
        //notify();
        condition.signal();

        reentrantLock.unlock();
    }

    /**
     * Если товаров на больше 2, то поток на поставку ожидает, освободив монитор.
     *  Вместимость склада - 3 продукта.
     * @throws InterruptedException - исключение.
     */
    public void put() throws InterruptedException {
        //synchronized
        reentrantLock.lock();

        if(productNum > 2) {
            //wait();
            condition.await();
        }
        productNum++;
        System.out.println("Поизводитель произвел и поставил 1 товар.");
        System.out.println("Товаров на складе: " + productNum);
        //notify();
        condition.signal();

        reentrantLock.unlock();
    }


}
