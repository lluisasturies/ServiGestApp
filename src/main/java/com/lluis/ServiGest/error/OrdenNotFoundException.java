package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrdenNotFoundException extends RuntimeException {

	public OrdenNotFoundException() {
        super("No se encuentra la orden");
    }
	
}
