public class Item {
    int worry;

    public Item(int initialWorry) {
        this.worry = initialWorry;
    }

    @Override
    public String toString() {
        return "Item(" + worry + ")";
    }
}
