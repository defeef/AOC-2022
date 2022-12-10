public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] asArray() {
        return new int[]{this.x, this.y};
    }
}
