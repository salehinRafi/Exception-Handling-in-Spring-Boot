package com.example.exceptionhandling.services;

import com.example.exceptionhandling.models.Greeting;
import com.example.exceptionhandling.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final ObjectsValidator<Greeting> greetingValidator;

    public String saveGreeting(Greeting greeting) {
        greetingValidator.validate(greeting);
        final String greetingMsg =
                "Greeting message <<" +
                        greeting.getMsg()
                        + ">> from: " +
                        greeting.getFrom().toUpperCase() +
                        " to: " +
                        greeting.getTo().toUpperCase();
        return greetingMsg;
    }
    public String throwException() {
        throw new IllegalStateException("Some exception happened");
    }
}
