package com.ibm.be.isco.resource.builder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IscoMessageConstants {

  public static final String TITLE_INTERNAL_SERVER_ERROR =
      HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
  public static final String TITLE_BAD_REQUEST = HttpStatus.BAD_REQUEST.getReasonPhrase();
  public static final String TITLE_ENTITY_NOT_FOUND = HttpStatus.NOT_FOUND.getReasonPhrase();

  public static final String INTERNAL_SERVER_ERROR_TYPE =
      "http://allianz.com/rest/problems/azbnl/eb/life/internalServerError";
  public static final String BAD_REQUEST_TYPE =
      "http://allianz.com/rest/problems/azbnl/eb/life/badRequest";
  public static final String ENTITY_NOT_FOUND_TYPE =
      "http://allianz.com/rest/problems/azbnl/eb/life/entityNotFound";

  public static final String BAD_REQUEST_DETAIL_VALIDATION_FAILED =
      "Validation failed for one or more parameters.";
}
