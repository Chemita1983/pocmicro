package com.javalab.book.domain.ports;

import com.javalab.book.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookPort {

    List<Book> getBooks();

    Optional<Book> getBookById(final Integer id);

    Book addBook(Book book);
}
