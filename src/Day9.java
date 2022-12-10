import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day9 {
    private int headX;
    private int headY;
    private int tailX;
    private int tailY;

    public Day9() {
        this.headX = 0;
        this.headY = 0;
        this.tailX = 0;
        this.tailY = 0;

        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day9.txt";
        InputToArray array = new InputToArray(2, path);
        ArrayList<String> list = array.list;
        
        ArrayList<Point> visited = new ArrayList<>();
        visited.add(new Point(tailX, tailY));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < Integer.parseInt(list.get(i).split(" ")[1]); j++) {
                switch (list.get(i).charAt(0)) {
                    case 'R': {
                        move(0);
                    } case 'D': {
                        move(1);
                    } case 'L': {
                        move(2);
                    } case 'U': {
                        move(3);
                    }
                }
                System.out.println("hx:" + headX + " hy:" + headY + " tx:" + tailX + " ty:" + tailY);
                System.out.println(visualize(headX, headY, tailX, tailY));
                visited.add(new Point(tailX, tailY));
            }
        }
        ArrayList<Point> unique = new ArrayList<Point>();
        for (Point point : visited) {
            if (!(unique.contains(point))) {
                unique.add(point);
            }
        }

        System.out.println(unique.size());
    }

    private void move(int dir) {
        int[][] dirs = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };
        Point[] offsets = new Point[]{
                new Point(2, 0),
                new Point(2, 1),
                new Point(1, 2),
                new Point(0, 2),
                new Point(-1, 2),
                new Point(-2, 1),
                new Point(-2, 0),
                new Point(-2, -1),
                new Point(-1, -2),
                new Point(0, -2),
                new Point(1, -2),
                new Point(2, -1),
        };

        headX += dirs[dir][0];
        headY += dirs[dir][1];

        Point diff = new Point(headX - tailX, headY - tailY);
        for (Point offset : offsets) {
            if (diff.equals(offset)) {
                tailX += offset.normalized().getX();
                tailY += offset.normalized().getY();
            }
        }
    }



    /*private void move(int dir) {
        int[][] dirs = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };

        headX += dirs[dir][0];
        headY += dirs[dir][1];
        if (dist(tailX, tailY, headX, headY) > 1) {
            int[] diff = diff(tailX, tailY, headX, headY);
            System.out.println("diff: " + diff[0] + ", " + diff[1]);
            if (Math.abs(diff[0]) > 1) {
                diff[0] = (int)Math.round(diff[0] / 2.0);
            } else if (Math.abs(diff[1]) > 1) {
                diff[1] = (int)Math.round(diff[1] / 2.0);
            }
            tailX += diff[0];
            tailY += diff[1];
        }
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);

    }

    private int[] diff(int x1, int y1, int x2, int y2) {
        return new int[]{x2 - x1, y2 - y1};
    }
    */
    private String visualize(int x1, int y1, int x2, int y2) {
        String r = "";
        String[][] grid = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = ".";
            }
        }
        Point offset = new Point(headX - tailX, headY - tailY);;
        grid[2 + offset.getX()][2 + offset.getY()] = "T";
        grid[2][2] = "H";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                r += grid[i][j];
            }
            r += "\n";
        }
        return r;
    }
}
