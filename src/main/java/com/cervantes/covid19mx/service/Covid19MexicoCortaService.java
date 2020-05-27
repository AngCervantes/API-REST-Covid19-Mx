package com.cervantes.covid19mx.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervantes.covid19mx.model.Catalogo_Municipio;
import com.cervantes.covid19mx.model.Covid19MexicoCorta;
import com.cervantes.covid19mx.payload.DatosPorMunicipio;
import com.cervantes.covid19mx.repository.ICovid19MexicoCortaRepository;
import com.cervantes.covid19mx.repository.IMunicipioRepository;

@Service
public class Covid19MexicoCortaService implements ICovid19MexicoCortaService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogoMunicipioService.class);

	@Autowired
	private ICovid19MexicoCortaRepository covidRepository;
	@Autowired
	private IMunicipioRepository municipioRepository;

	@Override
	public List<DatosPorMunicipio> getDatosPorMunicipio(String nombreDeMunicipio) {
		nombreDeMunicipio = nombreDeMunicipio.toUpperCase();
		List<Catalogo_Municipio> municipios = municipioRepository.findByMunicipioContains(nombreDeMunicipio);
		List<DatosPorMunicipio> datosDeMunicipios = new ArrayList<>();
		if (municipios != null) {
			if (!municipios.isEmpty()) {
				if (municipios.size() == 1) {
					List<Covid19MexicoCorta> casos = covidRepository.findByEntidadAndMunicipio(
							municipios.get(0).getEntidad().getClave_entidad(), municipios.get(0).getClave_municipio());
					DatosPorMunicipio municipioEncontrado = new DatosPorMunicipio();
					municipioEncontrado.setMunicipio(municipios.get(0));
					municipioEncontrado.setCasosTotales(casos);
					try {
						municipioEncontrado.obtenerDatos();
					} catch (ParseException ex) {
						logger.error(">> Ocurrio un error al obtener los datos de el municipio: { "
								+ municipioEncontrado.getMunicipio() + " }", ex.getCause());
					}
					datosDeMunicipios.add(municipioEncontrado);
				} else {
					logger.warn(">> Existe más de un municipio con esa coincidencia");
					for (Catalogo_Municipio municipio : municipios) {
						List<Covid19MexicoCorta> casos = covidRepository.findByEntidadAndMunicipio(
								municipio.getEntidad().getClave_entidad(), municipio.getClave_municipio());
						DatosPorMunicipio municipioEncontrado = new DatosPorMunicipio();
						municipioEncontrado.setMunicipio(municipio);
						municipioEncontrado.setCasosTotales(casos);
						try {
							municipioEncontrado.obtenerDatos();
						} catch (ParseException ex) {
							logger.error(">> Ocurrio un error al obtener los datos de el municipio: { "
									+ municipio.getMunicipio() + " }", ex.getCause());
						}
						datosDeMunicipios.add(municipioEncontrado);
					}
				}
				return datosDeMunicipios;
			} else {
				logger.error(">> La lista de municipios es vacía");
				return null;
			}
		} else {
			logger.error(">> La lista de municipios es nula");
			return null;
		}
	}

}
