package com.api.api_user.domain.exceptions;

import java.time.ZonedDateTime;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundExceptionModel{
    private int status;
    private ZonedDateTime timestamp;
    private String message;
}