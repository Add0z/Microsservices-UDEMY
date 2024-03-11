package br.udemy.andre.person.Repository;

import br.udemy.andre.person.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long>{

}