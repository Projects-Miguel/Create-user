package com.create.user.exceptions;

public class NoAutorizadoException extends Exception {
    public NoAutorizadoException(){
        super("Usuario no Autorizado");
    }
}
