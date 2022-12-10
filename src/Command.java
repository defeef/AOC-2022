public class Command {
    int arg;
    boolean isNoop;

    public Command(boolean isNoop, int arg) {
        this.isNoop = isNoop;
        this.arg = arg;
    }
}
