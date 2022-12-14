import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day13 {
    public Day13() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day13.txt";
        InputToArray array = new InputToArray(11, path);
        ArrayList<TreeNode> list = array.list;

        System.out.println(list.get(0));
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }
        System.out.println();
    }
}
