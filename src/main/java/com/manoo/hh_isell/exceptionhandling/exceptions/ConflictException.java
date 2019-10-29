package com.manoo.hh_isell.exceptionhandling.exceptions;

import com.manoo.hh_isell.exceptionhandling.APIBaseException;
import org.springframework.http.HttpStatus;

public class ConflictException extends APIBaseException {

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
