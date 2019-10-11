package multithreading.concurrencyTools.synchronizers.A_Semaphore;

public class CommonResource {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void increment() {
        this.counter++;
    }
}
