package br.gov.sp.fatec.service;

import java.util.Optional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;

public interface MateriaService {
	public Materia incluirMateria(String nome, int horas, Curso curso);
	
	public Optional<Materia> findById(Long id);
}
