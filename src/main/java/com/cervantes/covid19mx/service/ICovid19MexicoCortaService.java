package com.cervantes.covid19mx.service;

import java.util.List;

import com.cervantes.covid19mx.model.Catalogo_Municipio;
import com.cervantes.covid19mx.model.Covid19MexicoCorta;
import com.cervantes.covid19mx.payload.DatosPorMunicipio;

public interface ICovid19MexicoCortaService {
	
	public List<DatosPorMunicipio> getDatosPorMunicipio(String nombreDeMunicipio);

}
