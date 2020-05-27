package com.cervantes.covid19mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "catalogo_entidad")
public class Catalogo_Entidad {
	
	@Id
	@Column(length = 4)
	private String clave_entidad;
	@Column(length = 45)
	private String entidad_federativa;
	@Column(length = 4)
	private String abreviatura;
	
}
