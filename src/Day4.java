import java.util.ArrayList;

public class Day4 {
    public Day4() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day4.txt";
        InputToArray array = new InputToArray(3, path);

        int score = 0;
        for (int i = 0; i < array.list.size(); i++) {
            int[] ranges = (int[])array.list.get(i);
            if ((ranges[0] >= ranges[2] && ranges[1] <= ranges[3]) || (ranges[2] >= ranges[0] && ranges[3] <= ranges[1])) {
                score++;
            }
        }
        System.out.println(score);
    }
}
