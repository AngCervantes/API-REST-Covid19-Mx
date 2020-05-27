package com.cervantes.covid19mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervantes.covid19mx.model.Catalogo_Municipio;

@Repository
public interface IMunicipioRepository extends JpaRepository<Catalogo_Municipio, String> {
	
	List<Catalogo_Municipio> findByMunicipio(String municipio);
	
	List<Catalogo_Municipio> findByMunicipioContains(String municipio);
	

}
