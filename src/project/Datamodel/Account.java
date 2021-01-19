package project.Datamodel;

public class Account {
    private final String username;
    private final String login;
    private final String password;

    public Account(String... data){
        this.username = data[0];
        this.login = data[1];
        this.password = data[2];
    }

    public String getUsername(){
        return this.username;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }
}
