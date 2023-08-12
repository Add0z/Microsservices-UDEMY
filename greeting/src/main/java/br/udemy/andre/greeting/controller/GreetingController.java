package br.udemy.andre.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.udemy.andre.greeting.config.GreetingConfig;
import br.udemy.andre.greeting.model.Greeting;

@RestController
public class GreetingController {

    private static final String greetingTemplate = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfig greetingConfig;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(name = "name", 
                            defaultValue = "mundo") String name) {
        if (name.isEmpty()) {
            name = greetingConfig.getDefaultValue();
        }

        return new Greeting(counter.incrementAndGet(), 
                            String.format(greetingTemplate, greetingConfig.getGreeting(), name));
                            
        
    }
    
}
