package com.javalab.book.domain.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum GenreEnum {

    THRILLER("Thriller"),
    FANTASTIC("Fantastic"),
    SCIENCE_FICTION("Science_Fiction"),
    BLACK_NOVEL("Black_Novel"),
    HISTORIC("Historic"),
    LEARNING("Learning"),
    UNDEFINED("Undefined");

    final String value;

    GenreEnum(final String value){
        this.value = value;
    }

    public static String getGenreByName(final String genreName){
        return Arrays.stream(GenreEnum.values()).filter(genre -> genre.value.equalsIgnoreCase(genreName))
                .findFirst()
                .map(genreFounded -> genreFounded.name().toUpperCase())
                .orElseGet(() -> {
                    log.info("Genre {} not found", genreName);
                    return UNDEFINED.value.toUpperCase();
                });
    }
}
