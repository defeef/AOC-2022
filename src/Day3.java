import java.util.ArrayList;

public class Day3 {
    public Day3() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day3.txt";
        InputToArray array = new InputToArray(2, path);

        int score = 0;
        for (int i = 0; i < array.list.size(); i+=3) {
            String line1 = (String)array.list.get(i);
            String line2 = (String)array.list.get(i + 1);
            String line3 = (String)array.list.get(i + 2);

            score += priority(sameChar(line1, line2, line3));
        }
        System.out.println(score);
    }

    private ArrayList<String> types(String in) {
        ArrayList<String> types = new ArrayList<String>();
        for (int i = 0; i < in.length(); i++) {
            String chara = in.substring(i, i + 1);
            if (!types.contains(chara)) {
                types.add(chara);
            }
        }
        return types;
    }

    private String sameChar(ArrayList<String> aTypes, ArrayList<String> bTypes) {
        for (String aType : aTypes) {
            for (String bType : bTypes) {
                if (aType.equals(bType)) {
                    return aType;
                }
            }
        }
        return "";
    }

    private String sameChar(String aTypes, String bTypes, String cTypes) {
        for (int i = 0; i < aTypes.length(); i++) {
            for (int j = 0; j < bTypes.length(); j++) {
                for (int k = 0; k < cTypes.length(); k++) {
                    if (aTypes.substring(i, i + 1).equals(bTypes.substring(j, j + 1)) && bTypes.substring(j, j + 1).equals(cTypes.substring(k, k + 1))) {
                        return aTypes.substring(i, i + 1);
                    }
                }
            }
        }
        return "";
    }

    private int priority(String chara) {
        char[] chars = new char[1];
        chara.getChars(0, 1, chars, 0);
        int ascii = chars[0];
        if (ascii >= 97 && ascii <= 122) {
            ascii -= 96;
        } else {
            ascii -= 38;
        }
        System.out.println(ascii);
        return ascii;
    }
}
