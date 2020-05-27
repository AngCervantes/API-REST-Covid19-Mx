package com.cervantes.covid19mx.service;

import java.util.List;

import com.cervantes.covid19mx.model.Catalogo_Municipio;

public interface ICatalogoMunicipioService {
	
	public List<Catalogo_Municipio> getMunicipiosPorNombre(String nombre);

}
