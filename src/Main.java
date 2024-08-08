import enums.UserType;
import models.User;
import services.AdminService;
import services.UserRepository;
import java.util.Scanner;

public class Main {

    static void createUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full name.");
        String name = sc.nextLine();
        System.out.println("Enter email.");
        String email = sc.nextLine();
        System.out.println("Enter password (8-30 chars)");
        String password = sc.nextLine();

        AdminService.createUser(name, email, password);
    }

    static void deleteUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email of user you want to delete.");
        String email = sc.nextLine();
        AdminService.deleteUser(email);
    }
    static void showAdminMenu(){
        System.out.println("1. Create User");
        System.out.println("2. Delete User");
        System.out.println("3. View Users");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1 -> createUser();
            case 2 -> deleteUser();
            case 3 -> showUsers();
        }
    }

    static void showUsers(){
        for(User user: UserRepository.getUsers()){
            System.out.println("============== USER ===============");
            user.details();
        }
    }

    static void showUserMenu(){
        System.out.println("1. User");
    }
    static void login(String email, String password){
        final User user = UserRepository.searchUser(email);
        if(user!=null && user.validatePassword(password)){
            if(user.userType == UserType.ADMIN){
                showAdminMenu();
            }else {
                showUserMenu();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User admin = new User("Admin", "admin@gmail.com", "admin@123", UserType.ADMIN);
        UserRepository.addUser(admin);

        while (true){
            System.out.println("1. Login");
            System.out.println("2. Quit");

            int option = sc.nextInt();
            if (option==2){
                break;
            }
            sc = new Scanner(System.in);
            System.out.println("Enter email address.");
            String email = sc.nextLine();
            System.out.println("Enter password.");
            String password = sc.nextLine();
            login(email,password);
        }

    }
}