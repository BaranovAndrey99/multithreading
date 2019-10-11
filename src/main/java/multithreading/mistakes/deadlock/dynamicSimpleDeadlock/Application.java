package multithreading.mistakes.deadlock.dynamicSimpleDeadlock;

import multithreading.mistakes.deadlock.dynamicSimpleDeadlock.bug.BugTransferDispatcher;
import multithreading.mistakes.deadlock.dynamicSimpleDeadlock.fix.FixedTransferDispatcher;

public class Application {

    public static void main(String[] args) throws InterruptedException{
        Account account1 = new Account(1);
        Account account2 = new Account(2);

        Runnable task1 = () -> {
            //BugTransferDispatcher dispatcher = new BugTransferDispatcher(account1, account2, 1);
            FixedTransferDispatcher dispatcher = new FixedTransferDispatcher(account1, account2, 1);
            try {
                dispatcher.transferMoney();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            //BugTransferDispatcher dispatcher = new BugTransferDispatcher(account2, account1, 1);
            FixedTransferDispatcher dispatcher = new FixedTransferDispatcher(account2, account1, 1);
            try {
                dispatcher.transferMoney();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i < 100; i++) {
            Thread thread1 = new Thread(task1, "DeadlockThread1");
            Thread thread2 = new Thread(task2, "DeadlockThread2");

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();


            System.out.println("Attempt: " + i);
            System.out.println("Balance 1: " + account1.getBalance());
            System.out.println("Balance 2: " + account2.getBalance());

        }
    }
}
