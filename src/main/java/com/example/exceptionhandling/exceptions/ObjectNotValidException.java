package com.example.exceptionhandling.exceptions;

import lombok.Data;

import java.util.Set;
@Data
public class ObjectNotValidException extends RuntimeException  {
    public ObjectNotValidException(String message){
        super(message);
    }

}
