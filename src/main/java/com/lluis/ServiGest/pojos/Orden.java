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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrden;
	
	@ManyToOne
	@JoinColumn(name = "idVivienda")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Vivienda vivienda;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	@NotNull
	private Empresa empresa;
	
	@OneToMany(mappedBy = "orden")
	private List<OrdenLinea> lineas;
	
	@OneToMany(mappedBy = "orden")
	private List<OrdenCita> citas;
	
	@Column
	@NotNull
	private String orden;
	
	@Column
	@NotNull
	private String asunto;
	
	@Column
	@NotNull
	private LocalDate fecha;
	
	@Column(columnDefinition = "BIT DEFAULT 1")
	@NotNull
	private byte estado;
	
	

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public List<OrdenLinea> getLineas() {
		return lineas;
	}

	public void setLineas(List<OrdenLinea> lineas) {
		this.lineas = lineas;
	}

	public List<OrdenCita> getCitas() {
		return citas;
	}

	public void setCitas(List<OrdenCita> citas) {
		this.citas = citas;
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
