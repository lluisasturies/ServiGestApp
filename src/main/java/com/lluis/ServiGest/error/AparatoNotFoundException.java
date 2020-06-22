package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AparatoNotFoundException extends RuntimeException {

	public AparatoNotFoundException() {
        super("No se encuentra aparato");
    }
	
}
