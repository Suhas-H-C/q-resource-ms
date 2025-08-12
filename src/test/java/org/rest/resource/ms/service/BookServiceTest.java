package org.rest.resource.ms.service;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rest.resource.ms.model.Book;
import org.rest.resource.ms.model.IsbnNumber;
import org.rest.resource.ms.port.NumberPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.rest.resource.ms.util.BookTestUtil.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private Logger log;

    @Mock
    private NumberPort port;

    @InjectMocks
    private BookService service;

    @Test
    void should_return_Book_when_created() {
        when(port.getIsbnNumber()).thenReturn(isbn());
        Book book = service.createBook(bookTitle, author, yearOfPublication, genre);
        assertNotNull(book);
        assertEquals(bookTitle, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(yearOfPublication, book.getYearOfPublication());
        assertEquals(isbn().getIsbn13(), book.getIsbn13());
        assertEquals(genre, book.getGenre());
        verify(port).getIsbnNumber();
    }

    @Test
    void should_return_fallBack_isbn_response_when_port_is_down() {
        IsbnNumber isbnNumber = service.fallbackIsbnNumber();
        assertNotNull(isbnNumber);
        assertEquals("000-0000000000", isbnNumber.getIsbn13());
        verify(port, never()).getIsbnNumber();
    }
}