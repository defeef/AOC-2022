import java.util.ArrayList;
import java.util.Arrays;

public class Monkey {
    ArrayList<Item> items;
    String[] operation;
    int test;
    Monkey monkeyFalse;
    Monkey monkeyTrue;
    int throwFalse;
    int throwTrue;
    int inspections;

    public Monkey(ArrayList<Item> items, String operation, int test, int throwFalse, int throwTrue) {
        this.items = items;
        this.operation = operation.split(" ");
        this.test = test;
        this.throwFalse = throwFalse;
        this.throwTrue = throwTrue;
        this.inspections = 0;
    }

    public void chuck(Monkey receiving) {
        Item item = this.items.get(0);
        this.items.remove(0);
        receiving.items.add(item);
    }

    @Override
    public String toString() {
        return "Monkey(" + this.items + ", " + Arrays.toString(this.operation) + ", " + this.test + ", " + this.throwTrue + ", " + this.throwFalse + ", " + this.inspections + ")";
    }
}
