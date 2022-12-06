import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day5 {
    public Day5() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day5.txt";
        InputToArray array = new InputToArray(4, path);

        ArrayList<ArrayList<String>> stack = (ArrayList<ArrayList<String>>)array.list.get(0);

        for (int i = 1; i < array.list.size(); i++) {
            int[] line = (int[]) array.list.get(i);
            move(line, stack);
        }

        for (ArrayList<String> arr : stack) {
            for (String str : arr) {
                System.out.print(str + ", ");
            }
            System.out.println();
        }
    }

    private void move(int[] line, ArrayList<ArrayList<String>> stack) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < line[0]; i++) {
            int idx = topIndex(line, stack);
            temp.add(0, stack.get(line[1] - 1).get(idx));
            stack.get(line[1] - 1).remove(topIndex(line, stack));
        }
        for (int i = 0; i < line[0]; i++) {
            stack.get(line[2] - 1).add(temp.get(0));
            temp.remove(0);
        }
    }

    private int topIndex(int[] line, ArrayList<ArrayList<String>> stack) {
        ArrayList<String> column = stack.get(line[1] - 1);
        int idx = column.size() - 1;
        while (column.get(idx) == null) {
            idx--;
        }
        return idx;
    }
}
