package com.RHLM.projectGym.exception;

public class UserNoRegisteredException extends RuntimeException{
    public UserNoRegisteredException(String exMessage){
        super(exMessage);
    }

}
