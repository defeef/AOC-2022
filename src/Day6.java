import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day6 {
    public Day6() {
        String path = "Y:\\AP Computer Science A\\Baczkiewicz Henry A\\WORK\\AOC\\AOC-2022\\Day 5\\Day6.txt";
        InputToArray array = new InputToArray(5, path);
        ArrayList<String> list = (ArrayList<String>)array.list.get(0);
        
        int result = -1;
        for (int i = 13; i < list.size(); i++) {
            ArrayList<String> chars = new ArrayList<String>();
            for (int j = 0; j < 14; j++) {
                chars.add(list.get(i - j));
            }
            System.out.println(chars);
            if (allDistinct(chars)) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
    
    private boolean allDistinct(ArrayList<String> chars) {
        for (int i = 0; i < chars.size(); i++) {
            for (int j = i; j < chars.size(); j++) {
                boolean eq = chars.get(i).equals(chars.get(j));
                System.out.println(chars.get(i) + eq + chars.get(j));
                if (eq) {
                    return false;
                }
            }
        }
        return true;
    }
}
