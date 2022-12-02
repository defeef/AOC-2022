import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day2 {
    public Day2() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day2.txt";
        InputToArray array = new InputToArray(2, path);

        int score = 0;
        for (int i = 0; i < array.list.size(); i++) {
            int opp = -1;
            String line = (String) array.list.get(i);
            System.out.println(line);
            switch (line.substring(0, 1)) {
                case "A": {
                    opp = 0;
                    break;
                } case "B": {
                    opp = 1;
                    break;
                } case "C": {
                    opp = 2;
                }
            }
            System.out.print("opp: " + opp);
            int end = -1;
            switch (line.substring(2)) {
                case "X": {
                    end = 0;
                    break;
                } case "Y": {
                    end = 1;
                    break;
                } case "Z": {
                    end = 2;
                }
            }
            System.out.print(" me: " + end);

            score += need(opp, end);

            if (end == 1) {
                score += 3;
                System.out.println(" outcome: tie");
            } else if (end == 2) {
                score += 6;
                System.out.println(" outcome: win");
            } else {
                System.out.println(" outcome: loss");
            }
            System.out.println();
        }
        System.out.println(score);
    }
    private int need(int opp, int end) {
        if (opp == 0) {
            if (end == 0) {
                return 3;
            } else if (end == 1) {
                return 1;
            } else {
                return 2;
            }
        } else if (opp == 1) {
            if (end == 0) {
                return 1;
            } else if (end == 1) {
                return 2;
            } else {
                return 3;
            }
        } else {
            if (end == 0) {
                return 2;
            } else if (end == 1) {
                return 3;
            } else {
                return 1;
            }
        }
    }

    /*public Day2() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day2.txt";
        InputToArray array = new InputToArray(2, path);

        int score = 0;
        for (int i = 0; i < array.list.size(); i++) {
            int opp = -1;
            String line = (String) array.list.get(i);
            System.out.println(line);
            switch (line.substring(0, 1)) {
                case "A": {
                    opp = 0;
                    break;
                } case "B": {
                    opp = 1;
                    break;
                } case "C": {
                    opp = 2;
                }
            }
            System.out.print("opp: " + opp);
            int me = -1;
            switch (line.substring(2)) {
                case "X": {
                    me = 0;
                    score += 1;
                    break;
                } case "Y": {
                    me = 1;
                    score += 2;
                    break;
                } case "Z": {
                    me = 2;
                    score += 3;
                }
            }
            System.out.print(" me: " + me);
            if (opp == me) {
                score += 3;
                System.out.println(" outcome: tie");
            } else if (win(opp, me)) {
                score += 6;
                System.out.println(" outcome: win");
            } else {
                System.out.println(" outcome: loss");
            }
            System.out.println();
        }
        System.out.println(score);
    }
    private boolean win(int opp, int me) {
        if (opp == 0) {
            if (me == 1) {
                return true;
            }
            return false;
        } else if (opp == 1) {
            if (me == 2) {
                return true;
            }
            return false;
        } else {
            if (me == 0) {
                return true;
            }
            return false;
        }
    }*/
}
