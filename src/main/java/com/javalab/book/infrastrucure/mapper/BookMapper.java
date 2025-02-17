package com.javalab.book.infrastrucure.mapper;

import com.javalab.book.domain.model.Book;
import com.javalab.book.domain.model.GenreEnum;
import com.javalab.openapi.api.model.BookDTO;
import com.javalab.openapi.api.model.BookInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

@Mapper(imports = LocalDate.class)
public interface BookMapper {

    List<BookDTO> toBookDTOList(final List<Book> books);

    @Mapping(source = "genre", target = "category")
    @Mapping(source = "year", target = "year")
    Book toBook(final BookInputDTO bookInputDTO);

    @Mapping(source = "category", target = "genre", qualifiedByName = "mapGenre")
    @Mapping(target = "age", expression = "java(LocalDate.now().getYear() - book.year())")
    BookDTO toBookDTO(final Book book);

    @Named("mapGenre")
    default String mapGenre(final String value) {
        return GenreEnum.getGenreByName(value);
    }
}
