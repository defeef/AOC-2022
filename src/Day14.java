import java.util.ArrayList;
import java.util.Arrays;

public class Day14 {

    public Day14() {
        Point head = new Point(0, 0);
        Point[] tails = new Point[]{
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0),
        };

        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day14.txt";
        InputToArray array = new InputToArray(12, path);
        ArrayList<SandShape> list = (ArrayList<SandShape>)array.list;
        int maxX = 0;
        int maxY = 0;

        for (SandShape shape : list) {
            for (Point point : shape.points) {
                maxX = Math.max(maxX, point.getX());
                maxY = Math.max(maxY, point.getY());
            }
        }

        Point currentGrain = new Point(0, 500);

        boolean[][] grid = new boolean[maxX + 500][maxY + 1000];
        for (SandShape shape : list) {
            for (Point point : shape.getAllPoints()) {
                grid[point.getX()][point.getY()] = true;
            }
        }
        for (int i = 499; i < 530; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        int count = 1;
        while (currentGrain.getX() <= maxX) {
            if (!grid[currentGrain.getX() + 1][currentGrain.getY()]) {
                currentGrain.add(new Point(1, 0));
                System.out.println("Down");
            } else if (!grid[currentGrain.getX() + 1][currentGrain.getY() - 1]) {
                currentGrain.add(new Point(1, -1));
                System.out.println("Left");
            } else if (!grid[currentGrain.getX() + 1][currentGrain.getY() + 1]) {
                currentGrain.add(new Point(1, 1));
                System.out.println("Right");
            } else {
                System.out.println(currentGrain.getX() + ", " + currentGrain.getY());
                grid[currentGrain.getX()][currentGrain.getY()] = true;
                currentGrain = new Point(0, 500);
                count++;
            }
            System.out.println(currentGrain.getX() + ", " + currentGrain.getY());
        }

        System.out.println(count);
    }
}
