package com.example.exceptionhandling.controllers;

import com.example.exceptionhandling.exceptions.ObjectNotValidException;
import com.example.exceptionhandling.models.Greeting;
import com.example.exceptionhandling.services.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "GREETING_CONTROLLER")
@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @PostMapping
    public ResponseEntity<String> postGreeting(@RequestBody Greeting greeting
    ) {
        if(greeting==null){
            throw new ObjectNotValidException("Message Is Empty");
        }
        final String greetingMsg = service.saveGreeting(greeting);
        return ResponseEntity
                .accepted()
                .body(greetingMsg);
    }

    @GetMapping("/error")
    public ResponseEntity<?> throwException() {
        return ResponseEntity.ok(service.throwException());
    }
}
