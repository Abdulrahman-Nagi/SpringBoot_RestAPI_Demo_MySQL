package com.manoo.hh_isell.exceptionhandling.exceptions;

import com.manoo.hh_isell.exceptionhandling.APIBaseException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends APIBaseException {

    public NotFoundException(String message) {

        super(message);
    }


    public HttpStatus getStatusCode(){
        return HttpStatus.NOT_FOUND;
    }
}
