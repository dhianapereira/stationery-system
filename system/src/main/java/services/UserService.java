package services;

import domain.models.failure.SystemException;
import domain.models.user.AdminUser;
import domain.models.user.CommonUser;
import domain.models.user.User;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.Scanner;
public class UserService {
    public static String registration() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite 0 para comum e 1 para adm");
            int isAdmin = input.nextInt();
            System.out.println("cpf: ");
            String cpf = input.next();
            System.out.println("name: ");
            String name = input.next();
            System.out.println("age: ");
            int age = input.nextInt();
            System.out.println("password: ");
            String password = input.next();
            User user = null;
            if (isAdmin == 1) {
                user = new AdminUser(cpf, name, age, true, true, password);
            } else {
                user = new CommonUser(cpf, name, age, true, true, password);
            }
            return UserRepository.getInstance().registration(user);
        } catch (SystemException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static ArrayList<User> getUsers() {
        try {
            return UserRepository.getInstance().getUsers();
        } catch (SystemException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}