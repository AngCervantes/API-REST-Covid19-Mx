package com.cervantes.covid19mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervantes.covid19mx.model.Catalogo_Entidad;

@Repository
public interface IEntidadRepository extends JpaRepository<Catalogo_Entidad, String>  {

}
