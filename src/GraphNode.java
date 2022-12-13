import java.util.ArrayList;

public class GraphNode {
    ArrayList<GraphNode> adjacent;
    int value;
    int dist = 0;
    String name;
    boolean visited;
    GraphNode predecessor;
    // For grids
    int x;
    int y;

    public GraphNode(int value, int x, int y) {
        this.adjacent = new ArrayList<GraphNode>();
        this.value = value;
        this.x = x;
        this.y = y;
        this.visited = false;
        predecessor = null;
    }

    public void setDepth(int depth) {
        this.dist = depth;
        System.out.println(this.dist);
    }

    public void addVertex(GraphNode child) {
        this.adjacent.add(child);
        child.adjacent.add(this);
    }

    public GraphNode getAdjacent(int index) {
        return adjacent.get(index);
        // 0 right, 1 down, 2 left, 3 up
    }

    public void removeDuplicateAdjacent() {
        for (int i = 0; i < adjacent.size(); i++) {
            for (int j = i + 1; j < adjacent.size(); j++) {
                if (adjacent.get(i).equals(adjacent.get(j))) {
                    adjacent.remove(j);
                    j--;
                }
            }
        }
    }

    public boolean nextTo(GraphNode other) { // For grids
        if ((Math.abs(this.x - other.x) == 1 && Math.abs(this.y - other.y) == 0)
                || (Math.abs(this.x - other.x) == 0 && Math.abs(this.y - other.y) == 1)) {
            /*if (this.x == 1 && this.y == 1) {
                System.out.println(other.x + " " + other.y + " " + other.value + " " + true);
            }*/
            //System.out.println(this.x + " " + other.x + " " + this.y + " " + other.y);
            return true;
        }
        return false;
    }

    public void setLowDepth(int depth) {
        if (this.dist > 0) {
            this.setDepth(Math.min(this.dist, depth));
        } else {
            this.setDepth(depth);
        }
        System.out.println(this.dist);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String adjacent = "(";
        for (GraphNode node : this.adjacent) {
            adjacent += node.value + " ";
        }
        adjacent += ")";
        //try {
            return "Node(adj: " + adjacent + ", value: " + this.value + ", (" + x + ", " + y + "), " + this.visited + ")";
        //} catch (StackOverflowError e) {
            //return "";
        //}
    }

    @Override
    public boolean equals(Object other) {
        GraphNode node = (GraphNode)other;
        return this.value == node.value
                && this.x == node.x
                && this.y == node.y;
    }

    public boolean canTraverse(GraphNode other) {
        //System.out.println("Heights: " + this.value + " " + other.value);
        //System.out.println("This adj: " + this.adjacent);
        //System.out.println("Other adj: " + other.adjacent);
        for (GraphNode adj : this.adjacent) {
            if (this.value + 1 >= other.value && this.nextTo(other)) {
                return true;
            }
        }
        return false;
    }
}
