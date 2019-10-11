package multithreading.mistakes.raceCondition.fix;

public class SynchronizedFixedClass {
    private int counter = 0;

    public SynchronizedFixedClass() {
    }

    public synchronized void incrementMethod(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
