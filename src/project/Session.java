package project;

public class Session {
    private String token;
    private boolean firstLog;
    private static final Session instance = new Session();

    private Session(){}

    public static Session getInstance() {
        return instance;
    }

    public void unlock() {
        this.firstLog = false;
    }

    public void lock() {
        this.firstLog = true;
    }

    public boolean isFirstLog() {
        return this.firstLog;
    }

    public void setToken(String username){
        this.token = username;
    }

    public String getToken(){
        return this.token;
    }
}
