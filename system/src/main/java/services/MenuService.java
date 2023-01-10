package services;

import domain.enums.Action;
import domain.models.user.User;

import java.util.ArrayList;

public class MenuService {
    public static void selectAction(Action action){
        if(action == Action.createProduct){
            boolean result = ProductService.addProduct();
            if(result){
                System.out.println("Produto cadastrado com sucesso!");
            }
        }else if(action == Action.createUser){
            System.out.println(UserService.registration());
        }else if(action == Action.getUsers){
            ArrayList<User> users = UserService.getUsers();
            for(int i = 0; i<users.toArray().length; i++){
                System.out.println("CPF: " + users.get(i).getCpf());
                System.out.println("Nome: " + users.get(i).getName());
            }
        }else{
            System.out.println("Opção inválida!");
        }
    }
}
