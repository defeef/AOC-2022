import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day12 {
    public Day12() {
        String path = "Y:\\AP Computer Science A\\Baczkiewicz Henry A\\WORK\\AOC\\AOC-2022\\Day 5\\Day12.txt";
        InputToArray array = new InputToArray(10, path);
        ArrayList<ArrayList<Integer>> list = array.list;
        
        ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }
        System.out.println(visited.size());
    }
}
