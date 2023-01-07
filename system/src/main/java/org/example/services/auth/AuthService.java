package org.example.services.auth;

import org.example.entities.dto.AuthDTO;

import java.util.Scanner;

public class AuthService {
    public static boolean login(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Digite seu CPF: ");
            String cpf = input.next();
            System.out.println("Digite sua senha: ");
            String password = input.next();
            AuthDTO dto = new AuthDTO(cpf, password);
            System.out.println(dto.getCpf());
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
}
