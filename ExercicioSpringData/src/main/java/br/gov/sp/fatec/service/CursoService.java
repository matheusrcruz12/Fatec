package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;

public interface CursoService {
	
	public Curso incluirCurso(String nome);
	
	public Materia incluirMateria(String nome, String nomeCurso);

}
