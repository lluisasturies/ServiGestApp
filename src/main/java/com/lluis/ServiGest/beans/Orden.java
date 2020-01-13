package com.lluis.ServiGest.beans;

public class Orden {
	
	private Integer idOrden;
	private Integer idVivienda; // Relación con la Vivienda
	private Integer idEmpresa; // Relación con la Empresa
	private boolean cierre;
	private String informe;
	private String orden;
	private String asunto;
	private boolean pendiente;
	private boolean liquidada;
	private String factura;
	
}
