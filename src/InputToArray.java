import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputToArray {
    int type;
    ArrayList list;

    public InputToArray(int type, String filename) {
        this.type = type;
        this.list = new ArrayList();
        this.readFile(filename);
    }

    private void readFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            String line;
            try {
                line = scanner.nextLine();
            } catch (NoSuchElementException e) {
                scanner.close();
                return;
            }
            while (line != null) {
                this.list.add(this.convert(line));
                try {
                    line = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    scanner.close();
                    return;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object convert(String toConvert) {
        if (toConvert.equals("")) {
            switch (type) {
                case 0 -> {
                    return -1;
                }
                case 1 -> {
                    return -1.0;
                }
                case 2 -> {
                    return "";
                }default -> {
                    return "";
                }
            }
        }
        switch (type) {
            case 0 -> {
                return Integer.parseInt(toConvert);
            }
            case 1 -> {
                return Double.parseDouble(toConvert);
            }
            case 2 -> {
                return toConvert;
            }default -> {
                return toConvert;
            }
        }
    }
}
