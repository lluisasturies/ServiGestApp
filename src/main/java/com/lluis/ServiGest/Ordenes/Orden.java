package com.lluis.ServiGest.Ordenes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lluis.ServiGest.Empresas.Empresa;
import com.lluis.ServiGest.Viviendas.Vivienda;

@Entity
@Table(name="ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrden;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVivienda")
	private Vivienda idVivienda; // Relación con la Vivienda
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpresa")
	private Empresa idEmpresa; // Relación con la Empresa
	
	@Column
	private boolean cierre;
	
	@Column
	private String informe;
	
	@Column
	private String orden;
	
	@Column
	private String asunto;
	
	@Column
	private boolean pendiente;
	
	@Column
	private boolean liquidada;
	
	@Column
	private String factura;
	
}
