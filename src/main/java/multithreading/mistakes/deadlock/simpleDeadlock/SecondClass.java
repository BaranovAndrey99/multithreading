package multithreading.mistakes.deadlock.simpleDeadlock;

public class SecondClass {

    public synchronized void messageFromSecondClass() {
        System.out.println(Thread.currentThread().getName() + ": SecondClass message!");
    }
}
