package multithreading.concurrencyTools.forkJoin;

public class Application {
    public static void main(String[] args) {
        System.out.println(ForkJoinAdd.startForkJoinSum(1000000));
    }

}
