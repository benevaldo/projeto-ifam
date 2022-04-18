package com.api.api_user.domain.exceptions;

import java.time.ZonedDateTime;
// import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundExceptionModel {
    private int status;
    private String message;
    private ZonedDateTime timestamp;
}
