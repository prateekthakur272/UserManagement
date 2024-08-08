package services;
import models.User;

public class AdminService {
    static public void createUser(String name, String email, String password){
        User user = new User(name, email, password);
        UserRepository.addUser(user);
    }

    static public void deleteUser(String email){
        User user = UserRepository.searchUser(email);
        UserRepository.deleteUser(user);
    }
}
