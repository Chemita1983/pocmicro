package com.javalab.book.infrastrucure.api;

import com.javalab.book.domain.model.Book;
import com.javalab.book.domain.ports.BookUseCasePort;
import com.javalab.book.infrastrucure.mapper.BookMapper;
import com.javalab.openapi.api.BooksApi;
import com.javalab.openapi.api.model.BookDTO;
import com.javalab.openapi.api.model.BookInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController implements BooksApi {

    private final BookMapper bookMapper;

    private final BookUseCasePort bookUseCase;

    @Override
    public ResponseEntity<List<BookDTO>> booksGet() {
        List<Book> books = bookUseCase.getBooks();
        return new ResponseEntity<>(bookMapper.toBookDTOList(books), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDTO> booksIdGet(final Integer id) {
        Book bookById = this.bookUseCase.getBookById(id);
        BookDTO bookDTO = bookMapper.toBookDTO(bookById);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDTO> booksPost(final BookInputDTO bookInputDTO) {

        Book book = bookMapper.toBook(bookInputDTO);

        Book bookSaved = bookUseCase.addBook(book);

        BookDTO bookDTO = bookMapper.toBookDTO(bookSaved);

        return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
    }
}
