package com.cervantes.covid19mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "catalogo_municipio")
public class Catalogo_Municipio {
	
	@Id
	private int id_municipio;
	private int clave_municipio;
	@Column(length = 100)
	private String municipio;
	@ManyToOne
	@JoinColumn(name = "clave_entidad")
	private Catalogo_Entidad entidad;

}
