package org.nick.java.services;

public class UserAuthenticationService {

    public static boolean isUserValid(String username, String password){
        if(username.equals("nickath") && password.equals("123")){
            return true;
        }
        return false;
    }
}
