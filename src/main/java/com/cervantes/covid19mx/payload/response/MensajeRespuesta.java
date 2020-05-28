package com.cervantes.covid19mx.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensajeRespuesta {
	
	private String mensaje;

	public MensajeRespuesta(String mensaje) {
		this.mensaje = mensaje;
	}
}
