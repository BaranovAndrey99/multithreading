package multithreading.concurrencyTools.synchronizers.C_CyclicBarrier;

public class CommonCounter {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }
}
