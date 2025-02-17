package com.javalab.book.domain.ports;

import com.javalab.book.domain.model.Book;

import java.util.List;

public interface BookUseCasePort {

    List<Book> getBooks();

    Book getBookById(final Integer id);

    Book addBook(final Book book);
}
