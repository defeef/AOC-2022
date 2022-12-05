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
                if (this.type != 4) {
                    this.list.add(this.convert(new String[]{line}, false));
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                } else {
                    while (line != "") {
                        String[] arr = new String[9];
                        for (int i = 0; i < 9; i++) {
                            arr[i] = line.substring(i * 4, i * 4 + 4);
                        }
                        for (String str : arr) {
                            System.out.println(str + ", ");
                        }
                        this.list.add(this.convert(arr, false));
                        try {
                            line = scanner.nextLine();
                        } catch (NoSuchElementException e) {
                            scanner.close();
                            return;
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object convert(String[] toConvert, boolean secondPart) {
        if (toConvert[0].equals("")) {
            switch (type) {
                case 0: {
                    return -1;
                }
                case 1: {
                    return -1.0;
                }
                case 2: {
                    return "";
                } case 3: {
                    return new ArrayList<ArrayList<Integer>>();
                } case 4: {
                    return new int[]{0, 0, 0};
                } default: {
                    return "";
                }
            }
        }
        switch (type) {
            case 0: {
                return Integer.parseInt(toConvert[0]);
            }
            case 1: {
                return Double.parseDouble(toConvert[0]);
            }
            case 2: {
                return toConvert[0];
            } case 3: {
                int[] numbers = new int[4];
                String half1 = toConvert[0].split(",")[0];
                numbers[0] = Integer.parseInt(half1.split("-")[0]);
                numbers[1] = Integer.parseInt(half1.split("-")[1]);
                String half2 = toConvert[0].split(",")[1];
                numbers[2] = Integer.parseInt(half2.split("-")[0]);
                numbers[3] = Integer.parseInt(half2.split("-")[1]);
                return numbers;
            } case 4: {
                String[] type4Result1 = new String[9];
                int[] type4Result2 = new int[3];
                if (!secondPart) {
                    for (int i = 0; i < toConvert.length; i++) {
                        String str = toConvert[i];
                        if (!str.contains("[")) {
                            type4result1[i] =
                        }
                    }
                } else {
                    for (String str : toConvert) {
                        
                    }
                }
            } default: {
                    return toConvert;
            }
        }
    }
}
