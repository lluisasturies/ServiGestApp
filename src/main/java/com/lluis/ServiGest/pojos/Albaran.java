package com.lluis.ServiGest.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="albaranes")
public class Albaran {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAlbaran;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@NotNull
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "idOrden")
	@NotNull
	private Orden orden;
	
	@OneToMany(mappedBy = "albaran")
    private List<AlbaranLinea> lineas;
	
	@Column
	@NotNull
	private String codigoAlbaran;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column
	@NotNull
	private boolean facturado;

	
	
	public Integer getIdAlbaran() {
		return idAlbaran;
	}

	public void setIdAlbaran(Integer idAlbaran) {
		this.idAlbaran = idAlbaran;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public List<AlbaranLinea> getLineas() {
		return lineas;
	}

	public void setLineas(List<AlbaranLinea> lineas) {
		this.lineas = lineas;
	}

	public String getCodigoAlbaran() {
		return codigoAlbaran;
	}

	public void setCodigoAlbaran(String codigoAlbaran) {
		this.codigoAlbaran = codigoAlbaran;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	
}
