import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day8 {
    public Day8() {
        String path = "Y:\\AP Computer Science A\\Baczkiewicz Henry A\\WORK\\AOC\\AOC-2022\\Day 5\\Day8.txt";
        InputToArray array = new InputToArray(7, path);
        ArrayList<ArrayList<Integer>> list = array.list;
        
        System.out.println("dim: " + list.size() + ", " + list.get(0).size());
        int visible = 2 * list.size() + 2 * (list.get(0).size() - 2);
        for (int i = 1; i < list.size() - 1; i++) {
            for (int j = 1; j < list.get(i).size() - 1; j++) {
                System.out.println((((i * 99.0 + j) / (99.0 * 99.0)) * 100.0) + "%");
                if (isVisible(i, j, list)) {
                    visible++;
                }
            }
        }
        System.out.println(visible);
    }
    
    private boolean isVisible(int x, int y, ArrayList<ArrayList<Integer>> board) {
        return isVisible(x, y, board, 0)
        //|| isVisible(x, y, board, 1)
        //|| isVisible(x, y, board, 2)
        //|| isVisible(x, y, board, 3)
        ;
    }
    
    private boolean isVisible(int x, int y, ArrayList<ArrayList<Integer>> board, int dir) {
        int[][] dirs = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0},
        };
        
        if (dir == 0) {
            dx = 
        }
        
        int height = board.get(x).get(y);
        System.out.println("height: " + height);
        for (int i = x + dirs[dir][0]; i < board.size() && i > 0; i += dx) {
            for (int j = y + dirs[dir][1]; j < board.get(i).size() && j > 0; j += dy) {
                System.out.println("pos: " + i + ", " + j);
                System.out.println("boardTree: " + board.get(i).get(j));
                if (board.get(i).get(j) >= height) {
                    System.out.println();
                    return false;
                }
            }
        }
        System.out.println();
        return true;
    }
}
