package multithreading;

public class Application {
    private static int a = 0;
    public static void main(String[] args) {
        Runnable task1 = () -> {
            a = 1;
        };

        Runnable task2 = () -> {
            a = 2;
        };

        for(int i = 0; i < 10000000; i++) {
            new Thread(task1).start();
            new Thread(task2).start();
        }
    }
}
