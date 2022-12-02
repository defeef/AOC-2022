import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1 {
    public Day1() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\src\\Day1.txt";
        InputToArray<Integer> array = new InputToArray<Integer>(0, path);

        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int count = 0;
        for (int i = 0; i < array.list.size(); i++) {
            int val = (int)array.list.get(i);
            if (val == -1) {
                max3 = Math.max(count, max3);
                if (max2 < max3) {
                    int temp = max2;
                    max2 = max3;
                    max3 = temp;
                }
                if (max1 < max2) {
                    int temp = max1;
                    max1 = max2;
                    max2 = temp;
                }
                count = 0;
            } else {
                count += (int) array.list.get(i);
            }
        }
        System.out.println(max1 + max2 + max3);
    }
}
