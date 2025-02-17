package com.javalab.common.advice;


import com.javalab.common.error.ErrorCode;
import com.javalab.common.exception.ElementNotFoundException;
import com.javalab.openapi.api.model.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ResponseHandlerControllerAdvice {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerElementNotFoundException(final ElementNotFoundException exception) {
        log.error(":: Element not found :: ", exception);
        final ErrorDTO error = new ErrorDTO();
        error.setCode(ErrorCode.PRODUCT_NOT_FOUND.getCode());
        error.setMessage(ErrorCode.PRODUCT_NOT_FOUND.getMessage());
        error.setLevel(ErrorCode.PRODUCT_NOT_FOUND.getLevel());
        error.setDescription(ErrorCode.PRODUCT_NOT_FOUND.getDescription());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handlerException(final Exception exception) {
        log.error(":: Exception :: ", exception);
        final ErrorDTO error = new ErrorDTO();
        error.setCode(ErrorCode.GENERIC_EXCEPTION.getCode());
        error.setMessage(ErrorCode.GENERIC_EXCEPTION.getMessage());
        error.setLevel(ErrorCode.GENERIC_EXCEPTION.getLevel());
        error.setDescription(ErrorCode.GENERIC_EXCEPTION.getDescription());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
