import java.util.ArrayList;

public class Day10 {
    public Day10() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day1.txt";
        InputToArray array = new InputToArray(8, path);
        ArrayList<ArrayList<Integer>> list = array.list;

        int register = 1;
        int cycle = 0;
        int strength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == 0) {
                cycle++;
            } else {
                cycle++;
                if (cycle % 40 == 20) {
                    strength += cycle * register;
                }
                cycle++;
                register += list.get(i).get(1);
            }
            if (cycle % 40 == 20) {
                strength += cycle * register;
            }
        }
        System.out.println(strength);
    }
}
