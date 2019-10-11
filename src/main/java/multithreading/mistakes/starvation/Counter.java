package multithreading.mistakes.starvation;

public class Counter {
    private long counter = 0;

    public synchronized void incrementCounter() {
        this.counter++;
    }
}
