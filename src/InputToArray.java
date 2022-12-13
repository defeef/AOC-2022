import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputToArray {
    int type;
    ArrayList list;
    int[] startAndEnd;

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
            int initCount = 0;
            ArrayList<ArrayList<String>> stacks = new ArrayList<ArrayList<String>>();
            int lineCount = 1;
            startAndEnd = new int[4];
            for (int i = 0; i < 9; i++) {
                stacks.add(new ArrayList<String>());
            }
            while (line != null) {
                if (this.type != 4 && this.type != 9 && this.type != 10) {
                    this.list.add(this.convert(new String[]{line}, false));
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                } else if (this.type == 10) {
                    ArrayList<Integer> arr = (ArrayList<Integer>)this.convert(new String[]{line}, false);
                    boolean last = false;
                    if (!(arr.contains(-1) || arr.contains(27))) {
                        last = true;
                    }
                    if (arr.contains(-1)) {
                        int idx = arr.indexOf(-1);
                        this.startAndEnd[0] = lineCount;
                        this.startAndEnd[1] = idx;
                        arr.remove(idx);
                        arr.add(idx, 1);
                        this.list.add(arr);
                    }
                    if (arr.contains(27)) {
                        int idx = arr.indexOf(27);
                        this.startAndEnd[2] = lineCount;
                        this.startAndEnd[3] = idx;
                        arr.remove(idx);
                        arr.add(idx, 26);
                        this.list.add(arr);
                    }
                    if (last) {
                        this.list.add(arr);
                    }
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                    lineCount++;
                } else if (this.type == 9) {
                    //ArrayList<Item> items = new ArrayList<Item>();
                    String operation = "";
                    int test = 0;
                    int throwFalse = 0;
                    int throwTrue = 0;
                    line = scanner.nextLine();
                    String[] splits = line.split(" ");
                    for (int i = 4; i < splits.length; i++) {
                        //items.add(new Item(Integer.parseInt(splits[i].split(",")[0])));
                    }
                    line = scanner.nextLine();
                    splits = line.split(" ");
                    for (int i = 6; i < splits.length; i++) {
                        operation += splits[i].split(",")[0] + " ";
                    }
                    operation = operation.stripTrailing();
                    line = scanner.nextLine();
                    splits = line.split(" ");
                    test = Integer.parseInt(splits[splits.length - 1]);
                    line = scanner.nextLine();

                    splits = line.split(" ");
                    throwTrue = Integer.parseInt(splits[splits.length - 1]);
                    line = scanner.nextLine();

                    splits = line.split(" ");
                    throwFalse = Integer.parseInt(splits[splits.length - 1]);
                    //line = scanner.nextLine();
                    //this.list.add(new Monkey(items, operation, test, throwFalse, throwTrue));
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                } else {
                    if (initCount < 8) {
                        String[] arr = new String[9];
                        for (int i = 0; i < 9; i++) {
                            arr[i] = line.substring(i * 4, i * 4 + 4);
                        }
                        for (int i = 0; i < 9; i++) {
                            if (arr[i].contains("[")) {
                                stacks.get(i).add(0, arr[i].substring(1, 2));
                            } else {
                                stacks.get(i).add(0, null);
                            }
                        }
                        try {
                            line = scanner.nextLine();
                        } catch (NoSuchElementException e) {
                            scanner.close();
                            return;
                        }
                        initCount++;
                        if (initCount == 8) {
                            this.list.add(stacks);
                        }
                    } else {
                        this.list.add(this.convert(new String[]{line}, true));
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
                } case 5: {
                    return "";
                } case 6: {
                    int[] r = new int[2];
                    r[0] = 0;
                    r[1] = 0;
                    return r;
                } case 7: {
                    return new ArrayList<Integer>();
                } case 8: {
                    int[] r = new int[2];
                    r[0] = 0;
                    r[1] = 0;
                    return r;
                } case 10: {
                    return new ArrayList<Integer>();
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
                            type4Result1[i] = " ";
                        } else {
                            type4Result1[i] = str.substring(1, 2);
                        }
                    }
                    return type4Result1;
                } else {
                    String[] splits = toConvert[0].split(" ");
                    type4Result2[0] = Integer.parseInt(splits[1]);
                    type4Result2[1] = Integer.parseInt(splits[3]);
                    type4Result2[2] = Integer.parseInt(splits[5]);
                    return type4Result2;
                }
            } case 5: {
                ArrayList<String> result = new ArrayList<String>();
                for (int i = 0; i < toConvert[0].length(); i++) {
                    result.add(toConvert[0].substring(i, i + 1));
                }
                return result;
            } case 6: {
                String line = toConvert[0];
                int[] r = new int[2];
                String[] splits = line.split(" ");
                switch (splits[0]) {
                    case "D": {
                        r[0] = 1;
                        break;
                    } case "L": {
                        r[0] = 2;
                        break;
                    } case "U": {
                        r[0] = 3;
                        break;
                    }
                }
                r[1] = Integer.parseInt(splits[1]);
                //return new Point(r[0], r[1]);
            } case 7: {
                String line = toConvert[0];
                ArrayList<Integer> row = new ArrayList<Integer>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(Integer.parseInt(line.substring(i, i + 1)));
                }
                return row;
            } case 8: {
                String line = toConvert[0];
                int[] r = new int[2];
                String[] splits = line.split(" ");
                if (splits[0].equals("noop")) {
                    r[0] = 0;
                } else {
                    r[0] = 1;
                    r[1] = Integer.parseInt(splits[1]);
                }
                return r;
            } case 10: {
                String line = toConvert[0];
                ArrayList<Integer> elevations = new ArrayList<Integer>();
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    int ascii = (int)character;
                    if (character == 'S') {
                        elevations.add(-1);
                    } else if (character == 'E') {
                        elevations.add(27);
                    } else {
                        elevations.add(ascii - 96);
                    }
                }
                return elevations;
            } default: {
                return toConvert;
            }
        }
    }
}
