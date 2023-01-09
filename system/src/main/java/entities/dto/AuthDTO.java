package entities.dto;

public class AuthDTO {
    private String cpf;
    private String password;

    public AuthDTO(String cpf, String password){
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }
}
