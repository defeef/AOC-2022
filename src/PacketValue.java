import java.util.ArrayList;

public class PacketValue {
    //ArrayList<PacketValue> enclosed;
    int value;
    //PacketValue enclosing;
    
    public PacketValue(int value, PacketValue enclosing) {
        this.value = value;
        //this.enclosing = enclosing;
    }
    
    public PacketValue(PacketValue enclosing) {
        this.value = -1;
        //this.enclosing = enclosing;
    }
    
    public PacketValue() {
        this.value = -1;
        //this.enclosing = null;
    }

    @Override
    public String toString() {
        return "PacketValue(v: " + value + ")";
    }
}
