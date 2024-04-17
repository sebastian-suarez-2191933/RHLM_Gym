package com.RHLM.projectGym.exception;

public class SubscriptionInactiveUserException extends RuntimeException{

    public SubscriptionInactiveUserException(String exMessage){
        super(exMessage);
    }
}
