import java.util.ArrayList;

public class Day10 {
    public Day10() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day10.txt";
        InputToArray array = new InputToArray(8, path);
        ArrayList<int[]> list = array.list;

        String[][] crt = new String[6][40];

        int register = 1;
        int cycle = 0;
        drawCycle(register, cycle, crt);
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i)[0] == 0) {
                cycle++;
                if (cycle > 239) {
                    break;
                }
                drawCycle(register, cycle, crt);
            } else {
                cycle++;
                if (cycle > 239) {
                    break;
                }
                drawCycle(register, cycle, crt);
                cycle++;
                if (cycle > 239) {
                    break;
                }
                register += list.get(i)[1];
                drawCycle(register, cycle, crt);
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(crt[i][j]);
            }
            System.out.println();
        }
    }

    private void drawCycle(int register, int cycle, String[][] screen) {
        int[] coords = new int[]{cycle / 40, cycle % 40};
        System.out.println(coords[0] + ", " + coords[1] + " : " + register);
        if (register - 1 == coords[1] || register == coords[1] || register + 1 == coords[1]) {
            screen[coords[0]][coords[1]] = "#";
            return;
        }
        screen[coords[0]][coords[1]] = ".";
    }
}
