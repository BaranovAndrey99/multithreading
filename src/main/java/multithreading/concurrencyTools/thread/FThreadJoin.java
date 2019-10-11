package multithreading.concurrencyTools.thread;


public class FThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        Runnable task51 = () -> {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " is worked!");
            }
        };

        Runnable task52 = () -> {
            System.out.println(Thread.currentThread().getName() + " is started!");
        };

        Thread thread51 = new Thread(task51,"Thread 5-1");
        Thread thread52 = new Thread(task52,"Thread 5-2");

        thread51.start();

        thread51.join(1);

        thread52.start();
    }
}
