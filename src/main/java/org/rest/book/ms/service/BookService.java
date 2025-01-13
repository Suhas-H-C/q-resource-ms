package org.rest.book.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.rest.book.ms.model.Book;
import org.rest.book.ms.model.IsbnNumber;
import org.rest.book.ms.port.NumberPort;

import java.time.Instant;

@ApplicationScoped
public class BookService {

    @Inject
    Logger log;

    @RestClient
    NumberPort numberPort;

    public Book createBook(String title, String author, int yearOfPublication, String genre) {
        Book book = new Book();
        log.info("fetching isbn_13...");
        book.setIsbn13(fetchIsbnNumberOrFallBack().getIsbn13());
        log.info("isbn_13 fetched successfully");
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        book.setGenre(genre);
        book.setCreationDate(Instant.now());
        log.info("Book created successfully");
        return book;
    }

    @Retry(maxRetries = 2, delay = 3000)
    @Fallback(fallbackMethod = "fallbackIsbnNumber")
    public IsbnNumber fetchIsbnNumberOrFallBack() {
        return numberPort.getIsbnNumber();
    }

    public IsbnNumber fallbackIsbnNumber() {
        log.warn("Fallback method called for fetching isbn_13 as number-ms is not available");
        IsbnNumber fallbackIsbn = new IsbnNumber();
        fallbackIsbn.setIsbn13("000-0000000000");
        return fallbackIsbn;
    }
}
