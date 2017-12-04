package com.retail.target.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by pranith macha on 12/4/17.
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ConnectionException extends RuntimeException {


    public ConnectionException(String message) {
        super(message);
    }
}
