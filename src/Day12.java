import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Day12 {
    public Day12() {
        int[][] dirs = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };

        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day12.txt";
        InputToArray array = new InputToArray(10, path);
        ArrayList<ArrayList<Integer>> list = (ArrayList<ArrayList<Integer>>)array.list;
        
        ArrayList<GraphNode> graph = new ArrayList<GraphNode>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                graph.add(new GraphNode(list.get(i).get(j), i, j));
            }
        }

        for (GraphNode node : graph) {
            for (GraphNode other : graph) {
                if (node.nextTo(other)) {
                    node.addVertex(other);
                }
            }
        }

        for (GraphNode node : graph) {
            //System.out.println("x: " + other.x + " y: " + other.y + " nextTo: " + test.get(13).nextTo(other));
            node.removeDuplicateAdjacent();
            node.dist = Integer.MAX_VALUE;
        }

        GraphNode start = graph.get((array.startAndEnd[0] * list.get(0).size()) + array.startAndEnd[1]);
        GraphNode end = graph.get((array.startAndEnd[2] * list.get(0).size()) + array.startAndEnd[3]);

        // Test:


        /*ArrayList<GraphNode> test = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                test.add(new GraphNode(i * 5 + j, i, j));
            }

        }
        for (GraphNode node : graph) {
            for (GraphNode other : graph) {
                if (node.nextTo(other)) {
                    node.addVertex(other);
                }
            }
        }
        for (GraphNode other : test) {
            //System.out.println("x: " + other.x + " y: " + other.y + " nextTo: " + test.get(13).nextTo(other));
            System.out.println(test.get(13).adjacent);
        }*/


        //System.out.println(graph);

        ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
        ArrayList<GraphNode> queue1 = new ArrayList<GraphNode>();
        ArrayList<GraphNode> queue2 = new ArrayList<GraphNode>();

        queue1.add(0, start);
        while (!end.visited && (end.dist == Integer.MAX_VALUE)) {
            while (!queue1.isEmpty()) {
                GraphNode node = queue1.get(0);
                queue1.remove(0);
                for (GraphNode gn : node.adjacent) {
                    if (!gn.visited && node.canTraverse(gn)) {
                        queue2.add(gn);
                        gn.visited = true;
                        gn.setDepth(node.dist + 1);
                        gn.predecessor = node;
                    }
                }
            }
            queue1 = queue2;
            queue1.sort(Comparator.comparingInt(e -> e.dist));
            queue2 = new ArrayList<GraphNode>();
            String[][] visual = new String[list.size()][list.get(0).size()];
            for (GraphNode node : graph) {
                visual[node.x][node.y] = node.visited ? "#" : ".";
            }

            for (int i = 0; i < visual.length; i++) {
                for (int j = 0; j < visual[i].length; j++) {
                    System.out.print(visual[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        //if (queue1.isEmpty()) {
        //    System.out.println("Queue emptied");
        //}

        System.out.println("Steps: " + end.dist);
    }
}
