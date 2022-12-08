import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {
    public Day7() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day7.txt";
        InputToArray array = new InputToArray(6, path);

        int size = 0;
        ArrayList<Directory> unAssignned = new ArrayList<Directory>();
        for (int i = 0; i < array.list.size(); i++) {
            Directory dir = (Directory)array.list.get(i);
            dir.parseResult();
            dir.calcSize();
            unAssignned.add(dir);
        }

        for (int i = 0; i < unAssignned.size(); i++) {
            for (int j = 0; j < unAssignned.size(); j++) {
                if (unAssignned.get(i).getDirs().contains(unAssignned.get(j))
                && unAssignned.get(j).getDirs().size() == 1
                && unAssignned.get(j).getFiles().isEmpty()) {
                    unAssignned.remove(j);
                    j--;
                }
            }
        }

        while (!unAssignned.isEmpty()) {
            Directory queued = unAssignned.remove(0);
            System.out.println(queued);
            if (queued.getSize() < 100000) {
                size += queued.getSize();
            }
        }
        System.out.println("\n\n\n\n");
        System.out.println(size);
    }
}
