package com.lluis.ServiGest.pojos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="viviendas_aparatos")
public class ViviendaAparato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "FK_idVivienda")
	private Vivienda vivienda ;
	
	@ManyToOne
	@JoinColumn(name = "FK_idAparato")
	private Aparato aparato;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vivienda getIdVivienda() {
		return vivienda;
	}

	public void setIdVivienda(Vivienda idVivienda) {
		this.vivienda = idVivienda;
	}

	public Aparato getIdAparato() {
		return aparato;
	}

	public void setIdAparato(Aparato idAparato) {
		this.aparato = idAparato;
	}
	
}