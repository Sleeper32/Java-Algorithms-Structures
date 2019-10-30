package hash;

import javax.swing.*;
import java.util.LinkedList;

public class Hash<T> {
    private LinkedList<Item>[] buckets;
    private int size;
    private int elements;

    public Hash() {
        size = 3;
        buckets = alloc(size);

        elements = 0;
    }

    public T search(String key) throws InvalidKeyException {
        int hash = hashCode(key);
        LinkedList<Item> bucket = buckets[hash];

        for(Item tmpItem: bucket) {
            if (tmpItem.getKey().equals(key)) {
                return (T) tmpItem.getVal();
            }
        }

        throw new InvalidKeyException();
    }

    public void insert(String key, T val) {
        Item item = new Item(key, val);
        int hash = hashCode(key);

        buckets[hash].add(item);
        elements++;

        if ((elements * 100 / size) >= 70) {
            realloc();
        }
    }

    public Item delete(String key) throws InvalidKeyException {
        int hash = hashCode(key);
        LinkedList<Item> bucket = buckets[hash];

        for(Item item: bucket) {
            if (item.getKey().equals(key)) {
                Item tmpItem = item;
                bucket.remove(item);
                elements--;
                return tmpItem;
            }
        }

        throw new InvalidKeyException();
    }

    public void display() {
        for(int i = 0; i < size; i++) {
            for (Item tmpItem: buckets[i]) {
                System.out.println(tmpItem);
            }
        }
    }

    private int hashCode(String key) {
        return key.length() % size;
    }

    private LinkedList<Item>[] alloc(int size) {
        LinkedList<Item>[] buckets = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<Item>();
        }

        return buckets;
    }

    private void realloc() {
        LinkedList<Item>[] newBuckets;
        int oldSize = size;
        int newSize = size + 1;

        newBuckets = alloc(newSize);
        size = newSize;

        for(int i = 0; i < oldSize; i++) {
            for(Item tmpItem : buckets[i]) {
                int hash = hashCode(tmpItem.getKey());
                newBuckets[hash].add(tmpItem);
            }
        }

        buckets = newBuckets;
        size = newSize;
    }
}
