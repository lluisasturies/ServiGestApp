package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AparatoMarcaNotFoundException extends RuntimeException {

	public AparatoMarcaNotFoundException() {
        super("No se encuentra la marca de aparato");
    }
	
}
