import java.util.ArrayList;

public class Directory {
    private String name;
    
    private ArrayList<Directory> dirs;
    private ArrayList<AFile> files;
    
    public Directory(String name) {
        this.name = name;
        this.dirs = new ArrayList<Directory>();
        this.files = new ArrayList<AFile>();
    }
    
    public ArrayList<Directory> getDirs() {
        return this.dirs;
    }
    
    public ArrayList<AFile> getFiles() {
        return this.files;
    }
}
