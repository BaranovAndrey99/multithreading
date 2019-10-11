package multithreading.mistakes.raceCondition;

import multithreading.mistakes.raceCondition.bug.UnsafeClass;
import multithreading.mistakes.raceCondition.fix.AtomicFixedClass;
import multithreading.mistakes.raceCondition.fix.SynchronizedFixedClass;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        //UnsafeClass exampleClass = new UnsafeClass();
        //AtomicFixedClass exampleClass = new AtomicFixedClass();
        SynchronizedFixedClass exampleClass = new SynchronizedFixedClass();

        Runnable task = () -> {
            for(int i = 0; i < 1000; i++) {
                exampleClass.incrementMethod();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        System.out.println("Наши ожидаемые 2000: " + exampleClass.getCounter());
    }
}
