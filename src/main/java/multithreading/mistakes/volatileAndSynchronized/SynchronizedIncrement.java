package multithreading.mistakes.volatileAndSynchronized;

public class SynchronizedIncrement {
    private Integer variable = 0;

    public Integer getVolatileInteger() {
        return variable;
    }

    public synchronized void incrementForVolatile() {
        this.variable++;
    }
    /*
    public void incrementForVolatile() {
        synchronized (this) {
            this.volatileInteger++;
        }
    }
    */
}
