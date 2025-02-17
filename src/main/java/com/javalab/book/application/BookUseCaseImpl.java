package com.javalab.book.application;

import com.javalab.book.domain.model.Book;
import com.javalab.book.domain.ports.BookPort;
import com.javalab.book.domain.ports.BookUseCasePort;
import com.javalab.common.exception.ElementNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookUseCaseImpl implements BookUseCasePort {

    private final BookPort inMemoryBookRepository;

    @Override
    public List<Book> getBooks() {
        return this.inMemoryBookRepository.getBooks();
    }

    @Override
    public Book getBookById(final Integer id) {
        return this.inMemoryBookRepository.getBookById(id)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public Book addBook(Book book) {
        return inMemoryBookRepository.addBook(book);
    }
}
