package org.example.entities.models;

public class SystemException extends Exception {
    private String code;
    public SystemException(String code){
        this.code = code;
    }

    @Override
    public String getMessage(){
        if(code.equals("invalid_cpf")){
            return "CPF inválido!";
        }else if(code.equals("invalid_password")){
            return "Senha inválida!";
        } else if (code.equals("connection_failure")) {
            return "A conexão com o banco de dados falhou!";
        }

        return "Erro desconhecido!";
    }
}
