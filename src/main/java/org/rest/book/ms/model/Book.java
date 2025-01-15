package org.rest.book.ms.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(name = "Book", description = "Book model")
public class Book {

    @Schema(description = "ISBN 13 number", required = true)
    @JsonbProperty(value = "isbn_13")
    private String isbn13;
    @Schema(description = "Title of the book", required = true)
    private String title;
    @Schema(description = "Author of the book", required = true)
    private String author;
    @Schema(description = "Year of publication", required = true)
    @JsonbProperty(value = "year_of_publication")
    private int yearOfPublication;
    @Schema(description = "Genre of the book", required = true)
    private String genre;
    @Schema(description = "Creation date of the book", implementation = String.class, format = "date", required = true)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    @JsonbProperty(value = "creation_date")
    private Instant creationDate;

    public Book() {
    }

    public Book(String isbn13, String title, String author, int yearOfPublication, String genre, Instant creationDate) {
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
        this.creationDate = creationDate;
    }

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}