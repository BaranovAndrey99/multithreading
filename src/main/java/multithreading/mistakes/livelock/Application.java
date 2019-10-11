package multithreading.mistakes.livelock;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker("Vasily", true);
        Worker worker2 = new Worker("Petr", true);

        final Car car = new Car(worker1);

        Runnable worker1task = () -> {
            worker1.work(car, worker2);
        };

        Runnable worker2task = () -> {
            worker2.work(car, worker1);
        };

        Thread thread1 = new Thread(worker1task);
        Thread thread2 = new Thread(worker2task);

        thread1.start();
        thread2.start();
    }
}
