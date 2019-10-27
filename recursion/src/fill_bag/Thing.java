package fill_bag;

public class Thing {
    public int weight = 0;
    public int cost = 0;

    public Thing(int _weight, int _cost) {
        weight = _weight;
        cost = _cost;
    }

    public String toString() {
        return "weight: " + weight + ", cost: " + cost;
    }
}
