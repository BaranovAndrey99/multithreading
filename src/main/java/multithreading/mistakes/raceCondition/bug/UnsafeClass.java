package multithreading.mistakes.raceCondition.bug;

public class UnsafeClass {
    private Integer counter = 0;

    public UnsafeClass() {
    }

    public void incrementMethod(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
