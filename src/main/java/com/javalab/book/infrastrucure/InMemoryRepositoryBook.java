package com.javalab.book.infrastrucure;

import com.javalab.book.domain.model.Book;
import com.javalab.book.domain.ports.BookPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryRepositoryBook implements BookPort {

    private final List<Book> savedBooks = new ArrayList<>();

    @Override
    public List<Book> getBooks() {
        return this.savedBooks;
    }

    @Override
    public Optional<Book> getBookById(final Integer id) {
        return savedBooks.stream()
                .filter(book -> book.id().equals(id))
                .findFirst();
    }

    @Override
    public Book addBook(final Book book) {
        this.savedBooks.add(book);
        return book;
    }
}
