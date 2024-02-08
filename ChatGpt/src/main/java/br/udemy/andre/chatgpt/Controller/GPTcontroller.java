package br.udemy.andre.chatgpt.Controller;


import br.udemy.andre.chatgpt.Service.GPTservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "GPTcontroller")
@RequestMapping("/bot")
public class GPTcontroller {

    @Autowired
    private GPTservice service;

    @GetMapping(value = "/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        return service.chat(prompt);
    }

}
