package multithreading.concurrencyTools.locks.reentrantLockCondition.example;

public class Producer  implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                store.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
