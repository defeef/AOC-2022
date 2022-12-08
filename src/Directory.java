import java.util.ArrayList;
import java.util.Objects;

public class Directory {
    private String name;
    
    private ArrayList<Directory> dirs;
    private ArrayList<AFile> files;

    private Result result;

    private int size = -1;
    
    public Directory(String name, Result result) {
        this.name = name;
        this.result = result;
        this.dirs = new ArrayList<Directory>();
        this.files = new ArrayList<AFile>();
    }
    
    public ArrayList<Directory> getDirs() {
        return this.dirs;
    }
    
    public ArrayList<AFile> getFiles() {
        return this.files;
    }

    public void calcSize() {
        int direct = 0;
        int indirect = 0;
        for (AFile file : this.files) {
            direct += file.getSize();
        }
        for (Directory dir : this.dirs) {
            if (dir.getSize() < 0) {
                dir.calcSize();
            }
            indirect += dir.getSize();
        }
        this.size = direct + indirect;

    }

    public int getSize() {
        return size;
    }

    public void parseResult() {
        /*System.out.println("<res>");
        System.out.println(this.result);
        System.out.println("</res>");*/
        for (String resultLine : this.result.getResults()) {
            if (!resultLine.equals(this.name)) {
                if (resultLine.split(" ").length == 2) {
                    String[] splits = resultLine.split(" ");
                    this.files.add(new AFile(splits[1], Integer.parseInt(splits[0])));
                } else {
                    this.dirs.add(new Directory(resultLine, new Result()));
                }
            }
        }
        //System.out.println();
    }

    public Result getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        String r = "Dir[" + this.name + "](";
        for (AFile file : this.files) {
            r += " " + file.toString() + " ";
        }
        for (Directory dir : this.dirs) {
            r += " " + dir.toString() + " ";
        }
        r += ")";
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Directory directory = (Directory) o;
        return size == directory.size
                && Objects.equals(name, directory.name)
                && Objects.equals(dirs, directory.dirs)
                && Objects.equals(files, directory.files)
                && Objects.equals(result, directory.result)
        ;
    }
}
