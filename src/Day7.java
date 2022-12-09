import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {
    public Day7() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day7.txt";
        InputToArray array = new InputToArray(2, path);

        boolean listing = false;
        ArrayList<Node> unOrgNodes = new ArrayList<Node>();
        for (int i = 0; i < array.list.size(); i++) {
            String line = (String)array.list.get(i);
            String[] splits = line.split(" ");
            if (listing) {
                unOrgNodes.add(new Node(splits[1], splits[0].equals("dir")));
            }
            if (splits[0].equals("$")) {
                listing = false;
                if (splits[1].equals("ls")) { // $ ls
                    listing = true;
                }
            }
        }

        for (Node n : unOrgNodes) {
            System.out.println(n);
        }

        /*

        String currentDir = "";
        Node dirNode;
        listing = false;
        for (int i = 0; i < array.list.size(); i++) {
            String line = (String)array.list.get(i);
            String[] splits = line.split(" ");
            if (listing) {

            }
            if (splits[0].equals("$")) {
                listing = false;
                if (splits[1].equals("cd")) {
                    currentDir = splits[2];
                    dirNode = unOrgNodes.get(unOrgNodes.indexOf(new Node(currentDir, true)));
                } else { // $ ls
                    listing = true;
                }
            }
        }*/

        int size = 0;
        /*
        for (int i = 0; i < array.list.size(); i++) {
            size ++;
        }*/

        System.out.println();
        System.out.println(size);
    }
}
