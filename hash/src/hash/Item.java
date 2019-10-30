package hash;

public class Item<T> {
    private String key;
    private T val;

    public Item(String key, T val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public T getVal() {
        return val;
    }

    public String toString() {
        return String.format("key: %s, val: %s", key, val);
    }
}
