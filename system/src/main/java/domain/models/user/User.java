package domain.models.user;

import domain.enums.Action;

abstract public class User {
    protected String cpf;
    protected String name;
    protected String password;
    protected int age;
    protected boolean isActive;
    protected boolean isAdmin;
    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void menuActions(){
        System.out.println("PAPELARIA");
    }

    public Action getAction(int action){
        return null;
    }
}
