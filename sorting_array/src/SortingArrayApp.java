import java.time.Clock;
import java.util.Random;

import static java.lang.Math.abs;

public class SortingArrayApp {
    public static void main(String[] args) {
        RandomIntArray arr1, arr2, arr3, arr4;

        Clock clock = Clock.systemDefaultZone();
        long startTime, endTime;

        arr1 = new RandomIntArray(10);
        arr2 = new RandomIntArray(100000);
        arr3 = new RandomIntArray(100000);
        arr4 = new RandomIntArray(100000);

        //  Random array test
        arr1.printArray("random arr1");

        //  Insert item in array test
        arr1.insertItem(2, 0);
        arr1.printArray("arr1: insert item");

        //  Delete item from array test
        arr1.deleteItem(2);
        arr1.printArray("arr1: delete item");

        //  Search item in array test
        int index = arr1.searchItem(4);
        if (index != -1) {
            System.out.println("index item is " + index);
        }
        else {
            System.out.println("no value");
        }

        System.out.println();

        //  Bubble sort test
        startTime = clock.millis();
        arr2.bubbleSort();
        endTime = clock.millis();

        System.out.println("arr2: bubble sort: sorted for " + (endTime - startTime) + " ms");

        //  Insert sort test
        startTime = clock.millis();
        arr3.insertSort();
        endTime = clock.millis();

        System.out.println("arr3: insert sort: sorted for " + (endTime - startTime) + " ms");

        //  Selection sort test
        startTime = clock.millis();
        arr4.selectionSort();
        endTime = clock.millis();

        System.out.println("arr4: selection sort: sorted for " + (endTime - startTime) + " ms");
    }


}

class RandomIntArray {
    private int[] arr;
    private int num;

    RandomIntArray(int _num) {
        num = _num;

        generateRandomArray(num);
    }

    private void generateRandomArray(int num) {
        Random random = new Random();

        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = abs(random.nextInt() % 10);
        }
    }

    public void printArray(String label) {
        System.out.println(label);

        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("]");
        System.out.println();
    }

    public void insertItem(int index, int val) {
        if (index < 0 || index >= num) {
            System.out.println("Error: Wrong index");
            return;
        }

        for (int i = num-1; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = val;
    }

    public void deleteItem(int index) {
        if (index < 0 || index >= num) {
            System.out.println("Error: wrong index");
            return;
        }

        for (int i = index; i < num-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[num-1] = 0;
    }

    public int searchItem(int val) {
        for (int i = 0; i < num-1; i++) {
            if (arr[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public void bubbleSort() {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num-i; j++) {
                if (arr[j] > arr[j+1]) {
                    changeItems(j, j+1);
                }
            }
        }
    }

    public void insertSort() {
        for (int i = 1; i < num; i++) {
            int temp = arr[i];

            while(i > 0 && arr[i-1] > temp) {
                arr[i] = arr[i-1];
                --i;
            }

            arr[i] = temp;
        }

    }

    public void selectionSort() {
        for (int i = 0; i < num; i++) {
            int min = arr[i];
            int idx = i;

            for (int j = i+1; j < num; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }

            arr[idx] = arr[i];
            arr[i] = min;
        }
    }

    private void changeItems(int idx1, int idx2) {
        int tmp = arr[idx1];

        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
