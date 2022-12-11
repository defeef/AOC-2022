import java.util.ArrayList;

public class Day11 {
    public Day11() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day11.txt";
        InputToArray array = new InputToArray(9, path);
        ArrayList<Monkey> list = (ArrayList<Monkey>) array.list;

        for (int i = 0; i < list.size(); i++) {
            Monkey monkey = list.get(i);
            monkey.monkeyTrue = list.get(monkey.throwTrue);
            monkey.monkeyFalse = list.get(monkey.throwFalse);
        }
        for (int c = 0; c < 20; c++) {
            for (Monkey monkey : list) {
                while (!monkey.items.isEmpty()) {
                    Item item = monkey.items.get(0);
                    int newVal = 0;
                    int oldVal = item.worry;
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
                    item.worry = newVal / 3;
                    if (item.worry % monkey.test == 0) {
                        monkey.chuck(monkey.monkeyTrue);
                    } else {
                        monkey.chuck(monkey.monkeyFalse);
                    }
                }
            }
        }

        Monkey topMonkey = new Monkey(new ArrayList<Item>(), "", 0, 0, 0);
        Monkey runnerUpMonkey = new Monkey(new ArrayList<Item>(), "", 0, 0, 0);
        for (Monkey monkey : list) {
            if (monkey.inspections > topMonkey.inspections) {
                runnerUpMonkey = topMonkey;
                topMonkey = monkey;
            }
        }
        System.out.println(topMonkey);
        System.out.println(runnerUpMonkey);
        System.out.println("Monkey Business: " + (topMonkey.inspections * runnerUpMonkey.inspections));
    }
}
