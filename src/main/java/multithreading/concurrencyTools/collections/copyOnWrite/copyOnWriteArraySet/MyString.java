package multithreading.concurrencyTools.collections.copyOnWrite.copyOnWriteArraySet;

public class MyString {
    private String string;

    public MyString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
