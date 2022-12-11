import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Day11 {
    public Day11() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day11.txt";
        InputToArray array = new InputToArray(9, path);
        ArrayList<Monkey> list = (ArrayList<Monkey>) array.list;

        int maxMod = 1;
        for (int i = 0; i < list.size(); i++) {
            Monkey monkey = list.get(i);
            monkey.monkeyTrue = list.get(monkey.throwTrue);
            monkey.monkeyFalse = list.get(monkey.throwFalse);
            maxMod *= monkey.test;
        }
        for (int c = 0; c < 10000; c++) {
            for (Monkey monkey : list) {
                while (!monkey.items.isEmpty()) {
                    Item item = monkey.items.get(0);
                    long newVal = 0;
                    long oldVal = item.worry;
                    if (monkey.operation[0].equals("+")) {
                        if (monkey.operation[1].equals("old")) {
                            newVal = oldVal + oldVal;
                        } else {
                            newVal = oldVal + Integer.parseInt(monkey.operation[1]);
                        }
                    } else {
                        if (monkey.operation[1].equals("old")) {
                            newVal = oldVal * oldVal;
                        } else {
                            newVal = oldVal * Integer.parseInt(monkey.operation[1]);
                        }
                    }
                    monkey.inspections++;
                    item.setWorry(newVal, maxMod);// / 3;
                    if (item.worry % monkey.test == 0) {
                        monkey.chuck(monkey.monkeyTrue);
                    } else {
                        monkey.chuck(monkey.monkeyFalse);
                    }
                }
            }
            if (c % 10000 == 9999) {
                System.out.println(list);
            }
        }

        ArrayList<Monkey> sortedMonkeys = new ArrayList<Monkey>(list);
        Collections.sort(sortedMonkeys);

        Monkey topMonkey = sortedMonkeys.get(sortedMonkeys.size() - 1);
        Monkey runnerUpMonkey = sortedMonkeys.get(sortedMonkeys.size() - 2);

        System.out.println("\n\n");
        System.out.println(sortedMonkeys);
        System.out.println();
        System.out.println(topMonkey);
        System.out.println(runnerUpMonkey);
        System.out.println("Monkey Business: " + (topMonkey.inspections * runnerUpMonkey.inspections));
    }
}
// 2713310158
// 2713310158