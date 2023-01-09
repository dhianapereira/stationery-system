package services;

import domain.dto.AuthDTO;
import domain.models.failure.SystemException;
import domain.models.user.User;
import repositories.AuthRepository;
import utils.validators.CPFValidator;
import utils.ExceptionsUtils;
import utils.validators.PasswordValidator;
import java.util.Scanner;

public class AuthService {
    public static User login(){
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
            return null;
        }catch(Exception exception){
            System.out.println(ExceptionsUtils.message(exception));
            return null;
        }
    }
}
