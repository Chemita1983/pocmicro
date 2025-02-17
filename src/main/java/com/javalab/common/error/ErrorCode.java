package com.javalab.common.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
  NOT_IMPLEMENTED(String.valueOf(HttpStatus.NOT_IMPLEMENTED.value()), "Not Implemented ", "ERROR",
      "Endpoint not implemented."),
  MISSING_PARAM(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Missing Param", "ERROR",
      "Missing mandatory parameter"),
  PRODUCT_NOT_FOUND(String.valueOf(HttpStatus.NOT_FOUND.value()), "Not Found ", "ERROR",
          "Product not found"),
  GENERIC_EXCEPTION(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "Technical issue", "ERROR",
      "There is a technical issue, please try again later"),
  BAD_PARAM_EXCEPTION(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Wrong value Param", "ERROR",
      "Wrong value param in request");

  private final String code;

  private final String message;

  private final String level;

  private final String description;

  ErrorCode(final String code, final String message, final String level, final String description) {
    this.code = code;
    this.message = message;
    this.level = level;
    this.description = description;
  }
}
