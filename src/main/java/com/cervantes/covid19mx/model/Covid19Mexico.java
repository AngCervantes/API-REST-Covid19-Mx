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
@Table(name = "covid19Mexico")
public class Covid19Mexico {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(length = 45)
	private String idRegistro;
	private int origen;
	private int sector;
	private int entidad_um;
	private int sexo;
	private int entidad_nac;
	private int enitdad_res;
	private int municipio_res;
	private int tipo_paciente;
	private Date fecha_ingreso;
	private Date fecha_sintomas;
	private Date fecha_defuncion;
	private int intubado;
	private int neumonia;
	private int edad;
	private int nacionalidad;
	private int embarazo;
	private int habla_lengua_indigena;
	private int diabetes;
	private int epoc;
	private int asma;
	private int inmusupr;
	private int hipertension;
	private int otra_complicacion;
	private int cardiovascular;
	private int obesidad;
	private int renal_cronica;
	private int tabaquismo;
	private int otro_caso;
	private int resultado;
	private int migrante;
	@Column(length = 40)
	private String pais;
	private int pais_origen;
	private int uci;
	
	
	
	
	
	
	
	
}
