package com.cw.concurrent.inti;

public class RunnableDenyException extends RuntimeException{
    public RunnableDenyException(String message){
        super(message);
    }
}
