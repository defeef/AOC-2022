import java.util.ArrayList;

public class SandShape {
    ArrayList<Point> points;

    public SandShape() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public ArrayList<Point> getAllPoints() {
        ArrayList<Point> shapePoints = new ArrayList<>();
        shapePoints.add(this.points.get(0));
        for (int i = 0; i < this.points.size() - 1; i++) {
            Point p1 = this.points.get(i);
            Point p2 = this.points.get(i + 1);
            Point currentPoint = new Point(p1);
            Point move = p1.getX() != p2.getX() ? p1.getX() < p2.getX() ? new Point(1, 0) : new Point(-1, 0): p1.getY() < p2.getY() ? new Point(0, 1) : new Point(0, -1);
            while (!currentPoint.equals(p2)) {
                currentPoint.add(move);
                shapePoints.add(currentPoint);
            }
        }
        return shapePoints;
    }

    @Override
    public String toString() {
        return this.points.toString();
    }
}
