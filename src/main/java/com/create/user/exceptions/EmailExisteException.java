package com.create.user.exceptions;

public class EmailExisteException extends Exception{
    public EmailExisteException() {
        super("Correo ya existe en la base de datos");
    }
}
