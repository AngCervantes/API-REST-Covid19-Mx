package com.cervantes.covid19mx.payload;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cervantes.covid19mx.model.Catalogo_Municipio;
import com.cervantes.covid19mx.model.Covid19MexicoCorta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosPorMunicipio {

	private Catalogo_Municipio municipio;
	@JsonIgnore
	List<Covid19MexicoCorta> casosTotales;
	private int casosActivos;
	private int casosAcumulados;
	private int defunciones;
	private int casosRecuperados;
	@JsonIgnore
	private final int diasDeRecuperacion = 15;

	public void obtenerDatos() throws ParseException {		
		this.obtenerCasosAcumulados();
		this.obtenerCasosActivosYRecuperados();
		this.obtenerDefunciones();
	}

	private void obtenerCasosActivosYRecuperados() throws ParseException {
		if (this.casosTotales != null) {
			if (!this.casosTotales.isEmpty()) {
				Date fechaDeHoy = new Date();
				int recuperados = 0;
				int activos = 0;
				// --
				for (Covid19MexicoCorta caso : this.casosTotales) {
					Date fechaSintomas = caso.getFecha_sintomas();
					Calendar calendarRecuperacion = Calendar.getInstance();
					calendarRecuperacion.setTime(fechaSintomas);
					calendarRecuperacion.add(Calendar.DATE, this.diasDeRecuperacion);
					Date fechaRecuperacion = calendarRecuperacion.getTime();
					if (fechaDeHoy.compareTo(fechaRecuperacion) > 0) {
						if (!this.verificarDefuncion(caso.getFecha_defuncion())) {
							recuperados++;
						}
					} else {
						if (!this.verificarDefuncion(caso.getFecha_defuncion())) {
							activos++;
						}
					}
				}
				this.casosActivos = activos;
				this.casosRecuperados = recuperados;
			} else {
				this.casosActivos = 0;
				this.casosRecuperados = 0;
			}
		} else {
			this.casosActivos = 0;
			this.casosRecuperados = 0;
		}
	}

	private void obtenerCasosAcumulados() {
		if (this.casosTotales != null) {
			if (!this.casosTotales.isEmpty()) {
				this.casosAcumulados = this.casosTotales.size();
			} else {
				this.casosAcumulados = 0;
			}
		} else {
			this.casosAcumulados = 0;
		}
	}

	private void obtenerDefunciones() throws java.text.ParseException {
		if (this.casosTotales != null) {
			if (!this.casosTotales.isEmpty()) {
				int fallecidos = 0;
				for (Covid19MexicoCorta caso : this.casosTotales) {
					if (this.verificarDefuncion(caso.getFecha_defuncion())) {
						fallecidos++;
					}
				}
				this.defunciones = fallecidos;
			} else {
				this.defunciones = 0;
			}
		} else {
			this.defunciones = 0;
		}
	}

	private Boolean verificarDefuncion(Date fechaDefuncion) throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date noFallecido = sdformat.parse("2000-01-01");
		if (fechaDefuncion.compareTo(noFallecido) > 0) {
			return true;
		} else {
			return false;
		}
	}

}