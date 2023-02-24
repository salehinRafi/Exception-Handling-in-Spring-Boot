package com.example.exceptionhandling.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Greeting {

    @NotNull(message = "The MESSAGE should not be empty")
    @NotEmpty(message = "The MESSAGE should not be empty")
    private String msg;

    @NotNull(message = "The FROM should not be empty")
    @NotEmpty(message = "The FROM should not be empty")
    private String from;

    @NotNull(message = "The TO should not be empty")
    @NotEmpty(message = "The TO should not be empty")
    private String to;

}