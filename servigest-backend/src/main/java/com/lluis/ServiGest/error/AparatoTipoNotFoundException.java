package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AparatoTipoNotFoundException extends RuntimeException {

	public AparatoTipoNotFoundException() {
        super("No se encuentra el tipo de aparato");
    }
	
}
