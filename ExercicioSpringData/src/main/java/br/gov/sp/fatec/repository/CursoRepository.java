package br.gov.sp.fatec.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Curso;

import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	public Curso findByCurNome(String nome);
	
	public Curso findTop1ByCurNomeContains(String nome);
	
	public List<Curso> findByIdGreaterThan(Long id);
	
	//public List<Curso> findByMateriasNomeContainsIgnoreCase(String nome);
	
	//public List<Curso> findByNomeContainsIgnoreCaseOrMateriasNomeContainsIgnoreCase(String nomeCurso, String nomeMateria);
	
	@Query("select u from Curso u where u.curNome like %?1%")
	public List<Curso> buscaCurso(String nome);
}
