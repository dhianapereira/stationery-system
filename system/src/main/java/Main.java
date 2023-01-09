import domain.models.user.User;
import services.AuthService;

public class Main {
    public static void main(String[] args) {
        while(true){
           User user = null;
           do{
               user = AuthService.login();
               if(user==null){
                   System.out.println("Você precisará inserir os dados novamente.");
               }
           }while (user==null);

            System.out.println("Você está logado" + user.getClass().getSimpleName());
        }
    }
}