import domain.models.user.User;
import services.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
           User user = null;
           do{
               user = AuthService.login();
               if(user==null){
                   System.out.println("Você precisará inserir os dados novamente.");
               }
           }while (user==null);

           boolean isLogout = false;
           do {
               user.menuActions();
               int option = input.nextInt();
               if(option == 0){
                   System.out.println("Saindo do sistema...");
                   isLogout = true;
               }
               user.selectAction(option);
           }while(!isLogout);
        }
    }
}