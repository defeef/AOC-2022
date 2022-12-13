import java.util.ArrayList;

public class PacketValue<T> {
    T value;
    PacketValue enclosing;
    
    public PacketValue(T value, PacketValue enclosing) {
        this.value = value;
        this.enclosing = enclosing;
    }
    
    public PacketValue(PacketValue enclosing) {
        this.value = null;
        this.enclosing = enclosing;
    }
    
    public PacketValue() {
        this.value = null;
        this.enclosing = null;
    }
}
