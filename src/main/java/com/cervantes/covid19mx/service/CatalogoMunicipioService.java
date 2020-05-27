package com.cervantes.covid19mx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervantes.covid19mx.model.Catalogo_Municipio;
import com.cervantes.covid19mx.repository.IMunicipioRepository;

@Service
public class CatalogoMunicipioService implements ICatalogoMunicipioService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogoMunicipioService.class);

	@Autowired
	private IMunicipioRepository municipioRepository;

	@Override
	public List<Catalogo_Municipio> getMunicipiosPorNombre(String municipio) {
		municipio = municipio.toUpperCase();
		List<Catalogo_Municipio> municipios = municipioRepository.findByMunicipioContains(municipio);
		if (municipios != null) {
			if (!municipios.isEmpty()) {
				return municipios;
			} else {
				logger.error(">> La lista municipios esta vacía");
				return null;
			}
		} else {
			logger.error(">> La lista municipios es null");
			return null;
		}
	}

}
