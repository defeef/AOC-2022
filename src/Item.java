import java.math.BigInteger;

public class Item {
    long worry;

    public Item(long initialWorry) {
        this.worry = initialWorry;
    }

    public void setWorry(long worry, int mod) {
        if (worry < 0) {
            this.worry = (mod - Math.abs(worry)) % mod;
        } else {
            this.worry = worry % mod;
        }
    }

    @Override
    public String toString() {
        return "Item(" + worry + ")";
    }
}
