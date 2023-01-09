package domain.models.user;

import domain.interfaces.CommonActions;

public class AdminUser extends User implements CommonActions {
    public AdminUser(String cpf, String name, int age, boolean isActive, boolean isAdmin, String password){
        super(cpf, name, age, isActive, isAdmin, password);
    }
}
