package multithreading.mistakes.volatileAndSynchronized;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        SomeClass someClass = new SomeClass();
        SynchronizedIncrement synchronizedIncrement = new SynchronizedIncrement();

        Runnable volatileTask = someClass::incrementForVolatile;
        Runnable atomicTask = someClass::incrementForAtomic;
        Runnable customIncrement = synchronizedIncrement::incrementForVolatile;

        for(int i = 0; i < 100; i++) {
            new Thread(volatileTask).start();
            new Thread(volatileTask).start();
            new Thread(atomicTask).start();
            new Thread(atomicTask).start();
            new Thread(customIncrement).start();
            new Thread(customIncrement).start();
        }

        Thread.sleep(2000);

        System.out.println("Состояние volatile переменной: " + someClass.getVolatileInteger());
        System.out.println("Состояние atomic переменной: " + someClass.getAtomicInteger());
        System.out.println("Состояние переменной с синхронизированным инкрементом: " + synchronizedIncrement.getVolatileInteger());
    }
}
