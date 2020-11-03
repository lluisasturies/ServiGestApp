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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="albaranes")
@Getter
@Setter
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

}
