package multithreading.mistakes.deadlock.simpleDeadlock;

import org.w3c.dom.ls.LSOutput;

public class Application {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        SecondClass secondClass = new SecondClass();

        Runnable task1 = () -> {
            synchronized (secondClass) {
                secondClass.messageFromSecondClass();
                firstClass.messageFromFirstClass();
            }
        };

        Runnable task2 = () -> {
            synchronized (firstClass) {
                firstClass.messageFromFirstClass();
                secondClass.messageFromSecondClass();
            }
        };


        new Thread(task1, "Thread First Class").start();
        new Thread(task2, "Thread Second Class").start();
    }
}