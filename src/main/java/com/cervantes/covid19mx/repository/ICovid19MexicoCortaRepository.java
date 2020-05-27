package com.cervantes.covid19mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cervantes.covid19mx.model.Covid19MexicoCorta;

@Repository
public interface ICovid19MexicoCortaRepository extends JpaRepository<Covid19MexicoCorta, String> {
	
	@Query("SELECT c FROM Covid19MexicoCorta c WHERE c.entidad_res = :clave_entidad AND c.municipio_res = :clave_municipio AND c.resultado = 1")
	public List<Covid19MexicoCorta> findByEntidadAndMunicipio(int clave_entidad, int clave_municipio);
	
}
