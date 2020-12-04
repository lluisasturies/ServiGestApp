package com.lluis.ServiGest.dto;

import java.time.LocalDateTime;

public interface OrdenCitaProjection {

	Integer getIdCita();
	LocalDateTime getFechaCita();
	Integer getIdOrden();
	String getOrden();
	String getPrefijoEmpresa();
	Integer getIdVivienda();
	String getDireccion();

}
