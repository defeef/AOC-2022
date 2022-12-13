import java.util.ArrayList;

public class Day7 {
    public Day7() {
        String path = "C:\\Users\\henry\\Documents\\Coding\\Java\\AOC 2022\\AOC-2022\\src\\Day7.txt";
        InputToArray array = new InputToArray(2, path);

        boolean listing = false;
        ArrayList<TreeNode> unOrgNodes = new ArrayList<TreeNode>();
        unOrgNodes.add(new TreeNode("/", true, 0));
        for (int i = 0; i < array.list.size(); i++) {
            String line = (String)array.list.get(i);
            String[] splits = line.split(" ");
            if (splits[0].equals("$")) {
                listing = false;
                if (splits[1].equals("ls")) { // $ ls
                    listing = true;
                }
            }
            if (listing) {
                if (!splits[0].equals("dir") && !splits[0].equals("$")) {
                    unOrgNodes.add(new TreeNode(splits[1], false, Integer.parseInt(splits[0])));
                } else if (splits[0].equals("dir")) {
                    unOrgNodes.add(new TreeNode(splits[1], true, 0));
                }
            }
        }

        ArrayList<TreeNode> uniqueUnOrgNodes = new ArrayList<TreeNode>();

        for (TreeNode node : unOrgNodes) {
            if (!(uniqueUnOrgNodes.contains(node))) {
                uniqueUnOrgNodes.add(node);
                //System.out.println(node);
            }
        }

        String currentDir = "";
        TreeNode dirNode = uniqueUnOrgNodes.get(0);
        dirNode.setDepth(0);
        listing = false;
        for (int i = 0; i < array.list.size(); i++) {
            //System.out.println(dirNode);
            //System.out.println("|");
            String line = (String)array.list.get(i);
            String[] splits = line.split(" ");
            if (splits[0].equals("$")) {
                listing = false;
                if (splits[1].equals("cd") && !splits[2].equals("..")) {
                    currentDir = splits[2];
                    //System.out.println("name: " + currentDir);
                    int idx = uniqueUnOrgNodes.indexOf(new TreeNode(currentDir, true, 0));
                    if (idx >= 0) {
                        dirNode = uniqueUnOrgNodes.get(idx);
                    }
                } else if (splits[1].equals("ls")) {
                    listing = true;
                } else if (splits[2].equals("..")) {
                    if (dirNode.parent != null) {
                        dirNode = dirNode.parent;
                        currentDir = dirNode.name;
                    }
                }
            }
            if (listing && !splits[1].equals("ls")) {
                int size = 0;
                try {
                    size = Integer.parseInt(splits[0]);
                } catch (NumberFormatException e) {
                    size = 0;
                }
                TreeNode node = new TreeNode(splits[1], splits[0].equals("dir"), size);
                int idx = uniqueUnOrgNodes.indexOf(node);
                if (idx >= 0) {
                    //System.out.println(splits[1] + " " + splits[0].equals("dir"));
                    TreeNode addedNode = uniqueUnOrgNodes.get(idx);
                    addedNode.setDepth(dirNode.depth + 1);
                    dirNode.addChild(addedNode);
                }
            }
        }

        int size = 0;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(uniqueUnOrgNodes.get(0));
        TreeNode activeNode = queue.get(0);
        while (!queue.isEmpty()) {
            if (activeNode.getSize() <= 100000) {
                System.out.println(activeNode.getSize());
                size += activeNode.getSize();
            }
            queue.addAll(activeNode.children);
            queue.remove(activeNode);
            if (!queue.isEmpty()) {
                activeNode = queue.get(0);
            }
        }

        System.out.println();
        System.out.println(size);
    }
}
