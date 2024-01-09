package br.udemy.andre.bookservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;

    private String author;
    private Date publicationDate;
    private Double price;
    private String title;
    private String currency;
    private String environment;


    public Book() {}

    public Book(long id, String author, Date publicationDate, Double price, String title, String currency, String environment) {
        this.id = id;
        this.author = author;
        this.publicationDate = publicationDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
