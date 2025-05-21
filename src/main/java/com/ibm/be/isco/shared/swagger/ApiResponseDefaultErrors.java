package com.ibm.be.isco.shared.swagger;

import com.ibm.be.isco.resource.exception.ValidationErrorProblem;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@ApiResponse(
    responseCode = "400",
    description = "Bad Request",
    content = @Content(schema = @Schema(implementation = ValidationErrorProblem.class)))
@ApiResponse(
    responseCode = "401",
    description = "Unauthorized",
    content = @Content(schema = @Schema(implementation = Problem.class)))
@ApiResponse(
    responseCode = "403",
    description = "Forbidden",
    content = @Content(schema = @Schema(implementation = Problem.class)))
@ApiResponse(
    responseCode = "5XX",
    description = "Server Error",
    content = @Content(schema = @Schema(implementation = Problem.class)))
public @interface ApiResponseDefaultErrors {}
