import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day8 {
    public Day8() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day8.txt";
        InputToArray array = new InputToArray(7, path);
        ArrayList<ArrayList<Integer>> list = array.list;


        System.out.println("dim: " + list.size() + ", " + list.get(0).size());
        int largest = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            for (int j = 1; j < list.get(i).size() - 1; j++) {
                System.out.println((((i * 99.0 + j) / (99.0 * 99.0)) * 100.0) + "%");
                int sv = scenicValue(i, j, list);
                if (sv > largest) {
                    largest = sv;
                }
            }
        }
        System.out.println(largest);
    }
    
    private int scenicValue(int x, int y, ArrayList<ArrayList<Integer>> board) {
        return scenicValue(x, y, board, 0)
        * scenicValue(x, y, board, 1)
        * scenicValue(x, y, board, 2)
        * scenicValue(x, y, board, 3)
        ;
    }
    
    private int scenicValue(int x, int y, ArrayList<ArrayList<Integer>> board, int dir) {
        int[][] dirs = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0},
        };

        int dist = 0;
        int height = board.get(x).get(y);
        System.out.println("height: " + height);
        if (dir == 0 || dir == 2) {
            for (int i = y + dirs[dir][1]; i < 99 && i >= 0; i += dirs[dir][1]) {
                System.out.println("pos: " + x + ", " + i);
                System.out.println("boardTree: " + board.get(x).get(i));
                dist++;
                if (board.get(x).get(i) >= height) {
                    System.out.println();
                    return dist;
                }
            }
        } else {
            for (int i = x + dirs[dir][0]; i < 99 && i >= 0; i += dirs[dir][0]) {
                System.out.println("pos: " + i + ", " + y);
                System.out.println("boardTree: " + board.get(i).get(y));
                dist++;
                if (board.get(i).get(y) >= height) {
                    System.out.println();
                    return dist;
                }
            }
        }
        System.out.println();
        return dist;
    }
}
