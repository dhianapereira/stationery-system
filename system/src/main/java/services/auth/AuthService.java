package services.auth;

import entities.dto.AuthDTO;
import entities.models.SystemException;
import repositories.AuthRepository;
import utils.CPFValidator;
import utils.ExceptionsUtils;
import utils.PasswordValidator;
import java.util.Scanner;

public class AuthService {
    public static boolean login(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite seu CPF: ");
            String cpf = CPFValidator.validate(input.next());
            System.out.println("Digite sua senha: ");
            String password = PasswordValidator.validate(input.next());
            AuthDTO dto = new AuthDTO(cpf, password);
            return AuthRepository.getInstance().login(dto);
        } catch(SystemException exception){
            System.out.println(exception.getMessage());
            return false;
        }catch(Exception exception){
            System.out.println(ExceptionsUtils.message(exception));
            return false;
        }
    }
}