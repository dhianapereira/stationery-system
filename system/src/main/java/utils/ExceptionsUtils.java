package utils;

import java.util.InputMismatchException;

public class ExceptionsUtils {

    public static String message(Exception exception){
        if(exception.getClass().getSimpleName().equals("InputMismatchException")){
            return "O valor que você digitou é inválido!";
        }

        return "Erro desconhecido!";
    }
}
