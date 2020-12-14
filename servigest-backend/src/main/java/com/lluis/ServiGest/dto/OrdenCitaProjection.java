package com.lluis.ServiGest.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface OrdenCitaProjection {

	Integer getIdCita();
	LocalDate getFecha();
	LocalTime getHoraInicio();
	LocalTime getHoraFin();
	Integer getIdOrden();
	String getOrden();
	String getPrefijoEmpresa();
	Integer getIdVivienda();
	String getDireccion();

}
