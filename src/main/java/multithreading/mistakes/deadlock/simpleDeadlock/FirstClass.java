package multithreading.mistakes.deadlock.simpleDeadlock;

public class FirstClass {

    public synchronized void messageFromFirstClass() {
        System.out.println(Thread.currentThread().getName() + ": FirstClass message!");
    }
}
