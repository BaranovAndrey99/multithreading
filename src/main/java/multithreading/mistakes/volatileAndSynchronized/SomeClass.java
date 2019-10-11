package multithreading.mistakes.volatileAndSynchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class SomeClass {
    private volatile Integer volatileInteger = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public Integer getVolatileInteger() {
        return volatileInteger;
    }

    public Integer getAtomicInteger() {
        return atomicInteger.get();
    }

    public void incrementForVolatile() {
        this.volatileInteger++;
    }

    public void incrementForAtomic() {
        this.atomicInteger.incrementAndGet();
    }
}
