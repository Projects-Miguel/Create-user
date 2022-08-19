package com.create.user.exceptions;

public class UsernameOrPasswordInvalidException extends Exception{
    public UsernameOrPasswordInvalidException(){
        super("Usuario o Password invalido");
    }
}
