package org.example;

import org.example.services.auth.AuthService;

public class Main {
    public static void main(String[] args) {
        while(true){
           boolean isAuthenticated = false;
           do{
               isAuthenticated = AuthService.login();
               if(!isAuthenticated){
                   System.out.println("Você precisará inserir os dados novamente.");
               }
           }while (!isAuthenticated);

            System.out.println("Você está logado");
        }
    }
}