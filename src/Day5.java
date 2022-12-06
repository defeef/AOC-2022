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
            for (int j = 0; j < line[0]; j++) {
                int idx = topIndex(line, stack);
                String temp = stack.get(line[1] - 1).get(idx);
                stack.get(line[1] - 1).remove(idx);
                stack.get(line[2] - 1).add(temp);
            }
        }

        for (ArrayList<String> arr : stack) {
            for (String str : arr) {
                System.out.print(str + ", ");
            }
            System.out.println();
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
