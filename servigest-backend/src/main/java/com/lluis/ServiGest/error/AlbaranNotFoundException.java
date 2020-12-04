package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlbaranNotFoundException extends RuntimeException {

	public AlbaranNotFoundException() {
        super("No se encuentra el albaran");
    }
	
}