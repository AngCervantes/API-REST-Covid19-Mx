package com.cervantes.covid19mx.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.covid19mx.payload.DatosPorMunicipio;
import com.cervantes.covid19mx.payload.response.MensajeRespuesta;
import com.cervantes.covid19mx.service.Covid19MexicoCortaService;

@RestController
@RequestMapping("/api/covid")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Covid19MexicoRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(Covid19MexicoRestController.class);
	
	@Autowired
	private Covid19MexicoCortaService covidService;
	
	@GetMapping("/getByMunicipio")
	public ResponseEntity<?> getDatosPorMunicipio(@RequestParam(name = "municipio", required = true, defaultValue = "") String municipio){
		if (!municipio.equals("")) {
			List<DatosPorMunicipio> datosPorMunicipios = covidService.getDatosPorMunicipio(municipio);
			if (datosPorMunicipios != null) {
				return ResponseEntity.ok(datosPorMunicipios);
			} else {
				logger.error(">> La lista de municipios es nula");
				return ResponseEntity.badRequest().body(new MensajeRespuesta(
						"Error: ¡No se han encontrado coincidencias, verifica e inténtalo nuevamente!"));
			}
		} else {
			logger.error(">> El valor municipio está vacío");
			return ResponseEntity.badRequest().body(new MensajeRespuesta(
					"Error: ¡No se ha ingreaso los parametros correctos!"));
		}
	}

}
