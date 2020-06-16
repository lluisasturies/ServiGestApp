package com.lluis.ServiGest.pojos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="viviendas_aparatos")
public class ViviendaAparato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAparato;
	
	@ManyToOne
	@JoinColumn(name = "FK_idVivienda")
	@NotNull
	private Vivienda vivienda ;
	
	@ManyToOne
	@JoinColumn(name = "FK_idAparato")
	@NotNull
	private Aparato aparato;

	
	
	public Integer getIdAparato() {
		return idAparato;
	}

	public void setIdAparato(Integer idAparato) {
		this.idAparato = idAparato;
	}

	public Vivienda getIdVivienda() {
		return vivienda;
	}

	public void setIdVivienda(Vivienda idVivienda) {
		this.vivienda = idVivienda;
	}

	public Aparato getAparato() {
		return aparato;
	}

	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}
	
}