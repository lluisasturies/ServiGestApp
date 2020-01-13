package com.lluis.ServiGest.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="albaranes")
public class Albaran {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAlbaran;
	
	@OneToOne
	@JoinColumn(name = "idOrden")
	private Orden idOrden; // Relación con la Orden
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idLinea")
    private List<AlbaranLinea> lineas;
	
	@Column
	private String codigoAlbaran;
	
	@Column
	private String fecha; // Ver que tipo es el date de MySQL en Java
	
}
