package multithreading.concurrencyTools.synchronizers.B_CountDownLatch;

public class CommonCounter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }
}
