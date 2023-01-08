package org.example.services.auth;

import org.example.entities.dto.AuthDTO;
import org.example.entities.models.SystemException;
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
            System.out.println(dto.getCpf());
            return true;
        } catch(SystemException systemException){
            System.out.println(systemException.getMessage());
            return false;
        }catch(Exception exception){
            System.out.println(ExceptionsUtils.message(exception));
            return false;
        }
    }
}
