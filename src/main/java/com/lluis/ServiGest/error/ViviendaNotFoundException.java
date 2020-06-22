package com.lluis.ServiGest.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ViviendaNotFoundException extends RuntimeException {

	public ViviendaNotFoundException(Integer idVivienda) {
        super("No se encuentra la vivienda : " + idVivienda);
    }
	
}
