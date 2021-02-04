package project;

public class Session {
    private String token;
    private static final Session instance = new Session();

    private Session(){}

    public static Session getInstance() {
        return instance;
    }

    public void setToken(String username){
        this.token = username;
    }

    public String getToken(){
        return this.token;
    }
}
