package models;

import enums.UserType;

public class User {
    public String name;
    public String email;
    private String password;
    public UserType userType;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.userType = UserType.USER;
        setPassword(password);
    }

    public User(String name, String email, String password, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        setPassword(password);
    }
    void setPassword(String password){
        if(password.length() < 8 || password.length() > 30){
            throw new UnsupportedOperationException("Password length should be more than 8 and less than 30 characters.");
        }else{
        this.password = password;
        }
    }
    public boolean validatePassword(String password){
        return password.equals(this.password);
    }
    public void details(){
        System.out.println("Name: "+this.name);
        System.out.println("Email: "+this.email);
    }
}
