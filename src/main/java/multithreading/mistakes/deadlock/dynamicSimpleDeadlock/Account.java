package multithreading.mistakes.deadlock.dynamicSimpleDeadlock;

public class Account {
    private final Integer id;
    private Integer balance;

    public Account(Integer id) {
        this.id = id;
        this.balance = 10000;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void depositMoney(Integer sum) {
        this.balance -= sum;
    }

    public void withdrawMoney(Integer sum) {
        this.balance += sum;
    }
}
