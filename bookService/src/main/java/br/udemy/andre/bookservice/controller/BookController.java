package br.udemy.andre.bookservice.controller;


import br.udemy.andre.bookservice.model.Book;
import br.udemy.andre.bookservice.repository.BookRepo;
import br.udemy.andre.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/find/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {
        var book = bookRepo.getById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from","USD");
        params.put("to", currency);
        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio/" + "{amount}/{from}/{to}", Cambio.class,params);
        var cambio = response.getBody();
        book.setPrice(cambio.getConvertedValue());

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        return book;
    }
}
