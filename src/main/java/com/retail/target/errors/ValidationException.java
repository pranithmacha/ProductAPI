package com.retail.target.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by pranith macha on 12/4/17.
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {


    public ValidationException(String message) {
        super(message);
    }
}
