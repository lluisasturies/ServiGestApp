package com.lluis.ServiGest.datos.ordenes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lluis.ServiGest.datos.empresas.Empresa;
import com.lluis.ServiGest.datos.viviendas.Vivienda;

@Entity
@Table(name="ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrden;
	
	@ManyToOne
	@JoinColumn(name = "idVivienda")
	private Vivienda idVivienda; // Relación con la Vivienda
	
	@ManyToOne
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
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
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
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
