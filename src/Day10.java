import java.util.ArrayList;

public class Day10 {
    public Day10() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day10.txt";
        InputToArray array = new InputToArray(8, path);
        ArrayList<int[]> list = array.list;

        ArrayList<Integer> checks = new ArrayList<Integer>();

        checks.add(20);
        checks.add(60);
        checks.add(100);
        checks.add(140);
        checks.add(180);
        checks.add(220);

        int register = 1;
        int cycle = 1;
        int strength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == 0) {
                cycle++;
            } else {
                cycle++;
                if (checks.contains(cycle)) {
                    strength += cycle * register;
                    System.out.println(cycle + " : " + register + " : " + cycle * register + " : " + strength);
                }
                cycle++;
                register += list.get(i)[1];
            }
            if (checks.contains(cycle)) {
                strength += cycle * register;
                System.out.println(cycle + " : " + cycle * register + " : " + strength);
            }
        }
        System.out.println(strength);
    }
    
}
