import java.util.ArrayList;

public class Result {
    private boolean fromDir;
    private ArrayList<String> results;
    
    public Result(boolean fromDir, ArrayList<String> results) {
        this.results = new ArrayList<String>();
        this.fromDir = false;
        if (fromDir) {
            this.fromDir = true;
            this.results = results;
        }
    }
    
    public addResultLine()
}
