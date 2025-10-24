package com.library.librarymanagementsystem;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.librarymanagementsystem.model.Book;
import com.library.librarymanagementsystem.service.BookService;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    void addBookTest() {
        Book book = new Book("Test Title", "Author", "1234");
        Book saved = service.addBook(book);
        assertThat(saved.getId()).isNotNull();
    }
    @Test
void deleteBookTest() {
    // Add a temporary book
    Book book = new Book("Temp Book", "Author", "9999");
    Book saved = service.addBook(book);

    // Delete the book
    String result = service.deleteBook(saved.getId());
    assertThat(result).isEqualTo("Book deleted successfully");

    // Try deleting again
    String result2 = service.deleteBook(saved.getId());
    assertThat(result2).isEqualTo("Book not found");
}


}

