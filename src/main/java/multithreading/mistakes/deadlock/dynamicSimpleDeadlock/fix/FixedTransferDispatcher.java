package multithreading.mistakes.deadlock.dynamicSimpleDeadlock.fix;

import multithreading.mistakes.deadlock.dynamicSimpleDeadlock.Account;

/**
 * Dispatcher for money transfering
 */
public class FixedTransferDispatcher {
    private final Account accountFrom;
    private final Account accountTo;
    private final Integer sum;

    public FixedTransferDispatcher(Account accountFrom, Account accountTo, Integer sum) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.sum = sum;
    }

    public void transferMoney() throws InterruptedException {
        if(this.accountFrom.getId() > this.accountTo.getId()) {
            synchronized (this.accountFrom) {
                Thread.sleep(1000);
                synchronized (this.accountTo) {
                    if(this.accountFrom.getBalance().compareTo(this.sum) > 0) {
                        this.accountFrom.withdrawMoney(this.sum);
                        this.accountTo.depositMoney(this.sum);
                    } else {
                        System.out.println("EXCEPTION");
                    }
                }
            }
        } else {
            synchronized (this.accountTo) {
                Thread.sleep(1000);
                synchronized (this.accountFrom) {
                    if(this.accountFrom.getBalance().compareTo(this.sum) > 0) {
                        this.accountFrom.withdrawMoney(this.sum);
                        this.accountTo.depositMoney(this.sum);
                    } else {
                        System.out.println("EXCEPTION");
                    }
                }
            }
        }
    }
}

