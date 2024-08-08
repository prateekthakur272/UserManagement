package services;
import models.User;
import java.util.ArrayList;

public class UserRepository {
    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;
    public static void addUser(User user){
        users.add(user);
    }
    public static void deleteUser(User user){
        users.remove(user);
    }
    public static User searchUser(String email){
        for(User user: users){
            if(user.email.equals(email)){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers(){
        return users;
    }
}
