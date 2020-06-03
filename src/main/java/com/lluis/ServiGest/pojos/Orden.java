package com.lluis.ServiGest.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(mappedBy = "idOrden")
	@JsonIgnore
	private List<OrdenLinea> idTrabajo;
	
	@Column
	private String orden;
	
	@Column
	private String asunto;
	
	@Column
	private LocalDate fecha;
	
	@Column(columnDefinition = "BIT DEFAULT 1")
	private byte estado;
	
	
	
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

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
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
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
