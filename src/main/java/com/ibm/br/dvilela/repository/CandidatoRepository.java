package com.ibm.br.dvilela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ibm.br.dvilela.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

}
