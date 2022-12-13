import java.util.ArrayList;

public class Packet {
    ArrayList<PacketValue> values;
    
    public Packet(ArrayList<PacketValue> values) {
        this.values = values;
    }
    
    public Packet() {
        this.values = null;
    }
}
