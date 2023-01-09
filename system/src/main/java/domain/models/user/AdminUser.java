package domain.models.user;

import domain.interfaces.AdminUserActions;

public class AdminUser extends User implements AdminUserActions {
    public AdminUser(String cpf, String name, int age, boolean isActive, boolean isAdmin, String password){
        super(cpf, name, age, isActive, isAdmin, password);
    }

    @Override
    public void menuActions(){
        super.menuActions();
        System.out.println("(1) - Criar um novo usuário");
        System.out.println("(2) - Listar todos os usuários");
        System.out.println("(3) - Criar um novo produto");
        System.out.println("(4) - Listar todos os produtos");
        System.out.println("(0) - Sair");
    }
}
