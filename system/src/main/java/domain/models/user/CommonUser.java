package domain.models.user;

public class CommonUser extends User{
    public CommonUser(String cpf, String name, int age, boolean isActive, boolean isAdmin, String password){
        super(cpf, name, age, isActive, isAdmin, password);
    }

}