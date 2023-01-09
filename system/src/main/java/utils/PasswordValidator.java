package utils;

import entities.models.failure.SystemException;

public class PasswordValidator {
    public static String validate(String password) throws SystemException {
        if(password.length() < 6){
            throw new SystemException("invalid_password");
        }
        return password;
    }

}
