package br.udemy.andre.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "author" ,nullable = false)
    private String author;
    @Column(name = "publication_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String title;
    @Transient
    private String currency;
    @Transient
    private String environment;


    public Book() {}

    public Book(Long Id, String author, Date publicationDate, Double price, String title, String currency, String environment) {
        this.Id = Id;
        this.author = author;
        this.publicationDate = publicationDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getPublicationDate(), book.getPublicationDate()) && Objects.equals(getPrice(), book.getPrice()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getCurrency(), book.getCurrency()) && Objects.equals(getEnvironment(), book.getEnvironment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getPublicationDate(), getPrice(), getTitle(), getCurrency(), getEnvironment());
    }
}
