package multithreading.mistakes.livelock;

public class Car {
    private Worker currentWorker;

    public Car(Worker currentWorker) {
        this.currentWorker = currentWorker;
    }

    public Worker getCurrentWorker() {
        return currentWorker;
    }

    public synchronized void setCurrentWorker(Worker currentWorker) {
        this.currentWorker = currentWorker;
    }
}
