import java.util.ArrayList;

public class Day9 {

    public Day9() {
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

        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day9.txt";
        InputToArray array = new InputToArray(2, path);
        ArrayList<String> list = array.list;
        
        ArrayList<Point> visited = new ArrayList<>();
        visited.add(new Point(tails[8].getX(), tails[8].getY()));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < Integer.parseInt(list.get(i).split(" ")[1]); j++) {
                Point dir = new Point(0, 0);
                switch (list.get(i).split(" ")[0]) {
                    case "U": {
                        dir = Direction.NORTH;
                        break;
                    }
                    case "R": {
                        dir = Direction.EAST;
                        break;
                    }
                    case "D": {
                        dir = Direction.SOUTH;
                        break;
                    }
                    case "L": {
                        dir = Direction.WEST;
                        break;
                    }
                }
                move(head, dir);
                if (Math.abs(head.getX() - tails[0].getX()) > 1 || Math.abs(head.getY() - tails[0].getY()) > 1) {
                    moveTail(head, tails[0]);
                }
                for (int k = 1; k < 9; k++) {
                    if (Math.abs(tails[k - 1].getX() - tails[k].getX()) > 1 || Math.abs(tails[k - 1].getY() - tails[k].getY()) > 1) {
                        moveTail(tails[k - 1], tails[k]);
                    }
                }
                //System.out.println("hx:" + head.getX() + " hy:" + head.getY() + " tx:" + tail.getX() + " ty:" + tail.getY());
                //System.out.println(visualize(head, tails));
                visited.add(new Point(tails[8].getX(), tails[8].getY()));
            }
        }
        ArrayList<Point> unique = new ArrayList<Point>();
        for (Point point : visited) {
            if (!(unique.contains(point))) {
                unique.add(point);
                //System.out.println(point);
            }
        }

        System.out.println(unique.size());
    }

    private void moveTail(Point head, Point tail) {
        if (head.getX() > tail.getX() && head.getY() == tail.getY()) {
            move(tail, Direction.SOUTH);
        } else if (head.getX() < tail.getX() && head.getY() == tail.getY()) {
            move(tail, Direction.NORTH);
        } else if (head.getX() == tail.getX() && head.getY() > tail.getY()) {
            move(tail, Direction.EAST);
        } else if (head.getX() == tail.getX() && head.getY() < tail.getY()) {
            move(tail, Direction.WEST);
        } else if (head.getX() > tail.getX() && head.getY() > tail.getY()) {
            move(tail, Direction.SOUTHEAST);
        } else if (head.getX() < tail.getX() && head.getY() < tail.getY()) {
            move(tail, Direction.NORTHWEST);
        } else if (head.getX() < tail.getX() && head.getY() > tail.getY()) {
            move(tail, Direction.NORTHEAST);
        } else if (head.getX() > tail.getX() && head.getY() < tail.getY()) {
            move(tail, Direction.SOUTHWEST);
        }
    }

    private void move(Point pointToMove, Point direction) {
        pointToMove.add(direction);
    }

    /*
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
    */

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
    private String visualize(Point head, Point tail) {
        int size = 9;
        String r = "";
        String[][] grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ".";
            }
        }
        Point offset = new Point(head.getX() - tail.getX(), head.getY() - tail.getY());;
        grid[size / 2 + offset.getX()][size / 2 + offset.getY()] = "T";
        grid[size / 2][size / 2] = "H";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                r += grid[i][j];
            }
            r += "\n";
        }
        return r;
    }

    private String visualize(Point head, Point[] tails) {
        int size = 9;
        String r = "";
        String[][] grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ".";
            }
        }

        Point offset = new Point(head.getX() - tails[0].getX(), head.getY() - tails[0].getY());;
        grid[size / 2 + offset.getX()][size / 2 + offset.getY()] = "T";
        for (int i = 1; i < size; i++) {
            offset = new Point(head.getX() - tails[i].getX(), head.getY() - tails[i].getY());
            grid[size / 2 + offset.getX()][size / 2 + offset.getY()] = String.valueOf(i);
        }
        grid[size / 2][size / 2] = "H";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                r += grid[i][j];
            }
            r += "\n";
        }
        return r;
    }
}
