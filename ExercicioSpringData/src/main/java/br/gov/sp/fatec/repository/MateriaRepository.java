package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
	public Materia findByMatNome(String nome);
	
	public Optional<Materia> findById(Long id);
	/*
	@Query("select u from materia u where u.curso = (select c from curso c where c.curNome = ?)")
	public List<Materia> buscaMaterias(String nome);*/
}
