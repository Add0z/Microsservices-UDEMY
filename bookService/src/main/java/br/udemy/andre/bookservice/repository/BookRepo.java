package br.udemy.andre.bookservice.repository;

import br.udemy.andre.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}