package services;

import domain.enums.Action;

public class MenuService {
    public static void selectAction(Action action){
        if(action == Action.createProduct){
            System.out.println("Criar produto");
        }else if(action == Action.createUser){
            System.out.println("Criar usuário");
        }else{
            System.out.println("Opção inválida!");
        }
    }
}
