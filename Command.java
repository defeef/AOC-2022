public class Command {
    private boolean isDir;
    private String arg;
    
    private Result result;
    
    public Command(String com, String arg) {
        if (com.equals("dir")) {
            this.isDir = true;
            this.arg = "";
        } else {
            this.isDir = false;
            this.arg = arg;
        }
    }
    
    public boolean isDir() {
        return this.isDir;
    }
    
    public String getArg() {
        return this.arg;
    }
    
    public Result getResult() {
        return this.result;
    }
    
    public void addResult(String resultLine) {
        this.result.addResultLine(resultLine);        
    }
}
