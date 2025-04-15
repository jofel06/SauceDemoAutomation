package models;

public class LoginDataModel {
    private String username;
    private String password;

    //Getters
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    //Setters
    public void setUsername(String email) {
        this.username = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
