package br.udemy.andre.bookservice.controller;


import br.udemy.andre.bookservice.model.Book;
import br.udemy.andre.bookservice.proxy.CambioProxy;
import br.udemy.andre.bookservice.repository.BookRepo;
import br.udemy.andre.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private Environment environment;
    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/find/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {
        var book = bookRepo.getById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
        book.setPrice(cambio.getConvertedValue());
        var port = environment.getProperty("local.server.port");
        book.setEnvironment("book port" + port + " - cambio port" + cambio.getEnvironment());
        return book;
    }
}
