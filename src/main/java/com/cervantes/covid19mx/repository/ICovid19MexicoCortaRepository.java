package com.cervantes.covid19mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervantes.covid19mx.model.Covid19MexicoCorta;

@Repository
public interface ICovid19MexicoCortaRepository extends JpaRepository<Covid19MexicoCorta, String> {

}
