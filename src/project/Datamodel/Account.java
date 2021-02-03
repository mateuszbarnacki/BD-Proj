package project.Datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Account {
    private final SimpleStringProperty username = new SimpleStringProperty();
    private final String login;
    private final String password;

    public Account(String... data){
        this.username.set(data[0]);
        this.login = data[1];
        this.password = data[2];
    }

    public String getUsername(){
        return this.username.get();
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString(){
        return this.username.get();
    }
}
