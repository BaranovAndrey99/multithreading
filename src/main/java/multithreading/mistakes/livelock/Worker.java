package multithreading.mistakes.livelock;

public class Worker {
    private String name;
    private boolean awaiting;

    public Worker(String name, boolean awaiting) {
        this.name = name;
        this.awaiting = awaiting;
    }

    public String getName() {
        return name;
    }

    public boolean isAwaiting() {
        return awaiting;
    }

    public synchronized void work(Car car, Worker otherWorker) {
        while(awaiting) {
            if(car.getCurrentWorker() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            if(otherWorker.isAwaiting()) {
                System.out.println(otherWorker.getName() + "! Let's work!");
                car.setCurrentWorker(otherWorker);
                continue;
            }

            System.out.println(this.name + " worked!");
            awaiting = false;
            notifyAll();
        }
    }
}
