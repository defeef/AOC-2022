import java.util.ArrayList;

public class Node {
    String name;
    boolean isDir;
    ArrayList<Node> children;

    public Node(String name, boolean isDir) {
        this.name = name;
        this.isDir = isDir;
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public Node getChild(int index) {
        return children.get(index);
    }

    @Override
    public String toString() {
        return "Node(" + this.children.toString() + ", dir: " + this.isDir + ")";
    }

    public boolean equals(Node other) {
        return this.name.equals(other.name) && this.isDir == other.isDir;
    }
}
