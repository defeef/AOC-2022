import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
            int initCount = 0;
            ArrayList<ArrayList<String>> stacks = new ArrayList<ArrayList<String>>();

            Result currentRes = new Result();
            String dirName = "";
            
            for (int i = 0; i < 9; i++) {
                stacks.add(new ArrayList<String>());
            }
            while (line != null) {
                if (this.type != 4 && this.type != 6) {
                    this.list.add(this.convert(new String[]{line}, false));
                    try {
                        line = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        scanner.close();
                        return;
                    }
                } else if (this.type == 6) {
                    String str = line;
                    String[] splits = str.split(" ");
                    if (str.charAt(0) == '$') {
                        if (splits[1].equals("cd")) {
                            dirName = splits[2];
                        } else if (splits[1].equals("ls")) {
                            currentRes = new Result();
                            try {
                                line = scanner.nextLine();
                            } catch (NoSuchElementException e) {
                                scanner.close();
                                return;
                            }
                        }
                    } else if (splits[0].equals("dir")) {
                        list.add(new Directory(splits[1], currentRes));
                        currentRes.addResultLine(splits[1]);
                    } else {
                        currentRes.addResultLine(line);
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
            } default: {
                return toConvert;
            }
        }
    }
}
