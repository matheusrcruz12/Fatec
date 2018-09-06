package br.gov.sp.fatec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Faculdade;

public interface FaculdadeRepository extends CrudRepository<Faculdade, Long>{
	/*public Faculdade findByNome(String nome);
	
	public Faculdade findTop1ByNomeContains(String nome);
	
	public List<Faculdade> findByIdGreaterThan(Long id);
	
	public List<Faculdade> findByAutorizacoesNomeContainsIgnoreCase(String nome);
	
	public List<Faculdade> findByNomeContainsIgnoreCaseOrAutorizacoesNomeContainsIgnoreCase(String nomeFaculdade, String nomeCurso);
	
	@Query("select u from Faculdade u where u.nome like %?1%")
	public List<Faculdade> buscaFaculdade(String nome);*/
}
