import java.util.ArrayList;

public class Result {
    private ArrayList<String> results;
    
    public Result() {
        this.results = new ArrayList<String>();
    }
    
    public void addResultLine(String resultLine) {
        results.add(resultLine);
    }

    public ArrayList<String> getResults() {
        return this.results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
