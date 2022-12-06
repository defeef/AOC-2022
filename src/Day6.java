import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day6 {
    public Day6() {
        String path = "Y:\\AP Computer Science A\\Baczkiewicz Henry A\\WORK\\AOC\\AOC-2022\\Day 5\\Day6.txt";
        InputToArray array = new InputToArray(5, path);
        ArrayList<String> list = (ArrayList<String>)array.list.get(0);
        
        int result = -1;
        for (int i = 3; i < list.size(); i++) {
            ArrayList<String> chars = new ArrayList<String>();
            chars.add(list.get(i - 3));
            chars.add(list.get(i - 2));
            chars.add(list.get(i - 1));
            chars.add(list.get(i));
            System.out.println(chars);
            if (!chars.get(0).equals(chars.get(1))
            && !chars.get(1).equals(chars.get(2))
            && !chars.get(2).equals(chars.get(3))
            && !chars.get(0).equals(chars.get(2))
            && !chars.get(1).equals(chars.get(3))
            && !chars.get(0).equals(chars.get(3))) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
