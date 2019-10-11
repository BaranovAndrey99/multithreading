package multithreading.mistakes.raceCondition.fix;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicFixedClass {
    private AtomicInteger counter = new AtomicInteger(0);

    public AtomicFixedClass() {
    }

    public void incrementMethod(){
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int counter) {
        this.counter.set(counter);
    }
}
