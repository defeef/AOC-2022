import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Point normalized() {
        int newX = 0;
        int newY = 0;
        if (this.x > 1) {
            newX = 1;
        } else if (this.x < -1) {
            newX = -1;
        }
        if (this.y > 1) {
            newY = 1;
        } else if (this.y < -1) {
            newY = -1;
        }
        return new Point(newX, newY);
    }

    public void add(Point other) {
        this.x += other.getX();
        this.y += other.getY();
    }

    public int[] asArray() {
        return new int[]{this.x, this.y};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.getX() && y == point.getY();
    }

    @Override
    public String toString() {
        return "Point(" + this.getX() + ", " + this.getY() + ")";
    }
}
