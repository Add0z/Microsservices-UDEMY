package br.udemy.andre.bookservice.controller;


import br.udemy.andre.bookservice.model.Book;
import br.udemy.andre.bookservice.proxy.CambioProxy;
import br.udemy.andre.bookservice.repository.BookRepo;
import br.udemy.andre.bookservice.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Tag(name = "Book endpoint")
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private Environment environment;
    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a book by id")
    @GetMapping(value = "/find/{id}/{currency}")
    public Book findBook(@PathVariable Long id, @PathVariable String currency) {
        var book = bookRepo.getById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
        book.setPrice(cambio.getConvertedValue());
        book.setCurrency(currency);
        var port = environment.getProperty("local.server.port");
        book.setEnvironment("book port" + port + " - cambio port" + cambio.getEnvironment());
        return book;
    }
}
