package entities.models.failure;

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
        }else if(code.equals("non_existent_user")){
            return "Esse usuário não existe. Por favor, insira os dados para a autenticação de um usuário existente.";
        }

        return "Erro desconhecido!";
    }
}
