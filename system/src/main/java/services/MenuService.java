package services;

import domain.enums.Action;

public class MenuService {
    public static void selectAction(Action action){
        if(action == Action.createProduct){
            boolean result = ProductService.addProduct();
            if(result){
                System.out.println("Produto cadastrado com sucesso!");
            }
        }else if(action == Action.createUser){
            System.out.println("Criar usuário");
        }else{
            System.out.println("Opção inválida!");
        }
    }
}
