package domain.models.user;

import domain.enums.Action;

public class CommonUser extends User {
    public CommonUser(String cpf, String name, int age, boolean isActive, boolean isAdmin, String password){
        super(cpf, name, age, isActive, isAdmin, password);
    }

    @Override
    public void menuActions(){
        super.menuActions();
        System.out.println("(1) - Criar um novo produto");
        System.out.println("(2) - Listar todos os produtos");
        System.out.println("(0) - Sair");
    }

    @Override
    public Action getAction(int action){
        if(action==1){
            return Action.createProduct;
        }
        return null;
    }
}
