package com.cervantes.covid19mx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "covid19MexicoCorta")
public class Covid19MexicoCorta {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(length = 45)
	private String idRegistro;
	private Date fechaActualizacion;
	private int sexo;
	private int entidad_res;
	private int municipio_res;
	private int tipo_paciente;
	private Date fecha_ingreso;
	private Date fecha_sintomas;
	private Date fecha_defuncion;
	private int intubado;
	private int neumonia;
	private int edad;
	private int resultado;
	private int uci;
}
