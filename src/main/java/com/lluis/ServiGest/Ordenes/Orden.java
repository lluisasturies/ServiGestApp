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

	
	
	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Vivienda getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(Vivienda idVivienda) {
		this.idVivienda = idVivienda;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public boolean isCierre() {
		return cierre;
	}

	public void setCierre(boolean cierre) {
		this.cierre = cierre;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public boolean isPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}

	public boolean isLiquidada() {
		return liquidada;
	}

	public void setLiquidada(boolean liquidada) {
		this.liquidada = liquidada;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}
	
}
