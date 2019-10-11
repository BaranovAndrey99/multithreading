package multithreading.concurrencyTools.waitNotifyExample.example;

public class Store {
    private int productNum = 0;

    /**
     * Если товаров на скалде нет, то поток на покупку ожидает, освободив монитор.
     * @throws InterruptedException - исключение.
     */
    public synchronized void get() throws InterruptedException {
        if(productNum < 1) {
            wait();
        }
        productNum--;
        System.out.println("Покупатель приобрел 1 товар.");
        System.out.println("Товаров на складе: " + productNum);
        notify();
    }

    /**
     * Если товаров на больше 2, то поток на поставку ожидает, освободив монитор.
     *  Вместимость склада - 3 продукта.
     * @throws InterruptedException - исключение.
     */
    public synchronized void put() throws InterruptedException {
        if(productNum > 2) {
            wait();
        }
        productNum++;
        System.out.println("Поизводитель произвел и поставил 1 товар.");
        System.out.println("Товаров на складе: " + productNum);
        notify();
    }


}
