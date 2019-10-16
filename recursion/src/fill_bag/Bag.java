package fill_bag;

public class Bag {
    public int capacity;

    public int cost;
    public int weight;
    public int numThings;

    private int sumWeight;
    private int sumCost;
    private int count;

    public Bag(int _cap) {
        capacity = _cap;
    }

    public void fill(Thing[] things) {
        combination0(things, 0, things.length, 0, 0, 0);
    }

    private void combination0(Thing[] arr, int start, int end, int count, int sumWeight, int sumCost) {
        if (capacity >= sumWeight) {
            if (sumCost > cost) {
                cost = sumCost;
                weight = sumWeight;
                numThings = count;
            }
        }

        if (start == end) {
            return;
        }

        for (int i = start; i < end; i++) {
            combination0(arr, i + 1, end, count+1, sumWeight + arr[i].weight, sumCost + arr[i].cost);
        }
    }

    public String toString() {
        return "maxCost = " + cost + ", maxWeight = " + weight + ", things = " + numThings;
    }
}
