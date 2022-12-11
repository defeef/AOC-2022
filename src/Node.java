import java.util.ArrayList;

public class Node {
    String name;
    boolean isDir;
    ArrayList<Node> children;
    Node parent;
    int size;
    int depth;

    public Node(String name, boolean isDir, int size) {
        this.name = name;
        this.isDir = isDir;
        this.children = new ArrayList<Node>();
        this.size = size;
        parent = null;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void addChild(Node child) {
        this.children.add(child);
        child.parent = this;
    }

    public Node getChild(int index) {
        return children.get(index);
    }

    public int getSize() {
        if (!this.isDir) {
            return size;
        } else {
            if (this.children.size() > 0) {
                int s = 0;
                ArrayList<Node> queue = new ArrayList<Node>(children);
                Node activeNode = queue.get(0);
                while (!queue.isEmpty()) {
                    System.out.println(activeNode);
                    s += activeNode.getSize();
                    queue.addAll(activeNode.children);
                    queue.remove(activeNode);
                    if (!queue.isEmpty()) {
                        activeNode = queue.get(0);
                    }
                }
                return s;
            } else {
                return this.size;
            }
        }
    }

    @Override
    public String toString() {
        try {
            return "Node<" + this.name + ">(" + this.children.toString() + ", dir: " + this.isDir + ", size: " + this.size + ")";
        } catch (StackOverflowError e) {
            return this.name + " OVERFLOWED";
        }
    }

    @Override
    public boolean equals(Object other) {
        Node node = (Node)other;
        return this.name.equals(node.name) && this.isDir == node.isDir && this.depth == node.depth;
    }
}
