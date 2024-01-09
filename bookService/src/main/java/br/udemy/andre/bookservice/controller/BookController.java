package br.udemy.andre.bookservice.controller;


import br.udemy.andre.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private Environment environment;


@GetMapping(value = "/find/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {

    var port = environment.getProperty("local.server.port");


    return new Book(1L, "Andre", new Date(), Double.valueOf(10.0), "Book Title", currency, port);

}







}
