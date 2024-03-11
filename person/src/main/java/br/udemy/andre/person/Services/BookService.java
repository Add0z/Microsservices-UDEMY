package br.udemy.andre.person.Services;

import java.util.List;

import br.udemy.andre.person.BookVO.BookVO;
import br.udemy.andre.person.Model.Book;
import br.udemy.andre.person.Repository.BookRepository;
import br.udemy.andre.person.exceptions.ResourceNotFoundExcep;
import br.udemy.andre.person.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public BookVO create(BookVO book) {
        var entity = PersonMapper.parseObject(book, Book.class);
        var vo = PersonMapper.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public List<BookVO> findAll() {
        return PersonMapper.parseListObject(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcep("No records found for this ID"));
        return PersonMapper.parseObject(entity, BookVO.class);
    }

    public BookVO update(BookVO book) {
        var entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundExcep("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = PersonMapper.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcep("No records found for this ID"));
        repository.delete(entity);
    }

}