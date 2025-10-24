package com.library.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.librarymanagementsystem.model.Book;
import com.library.librarymanagementsystem.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public List<Book> searchBooks(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}
