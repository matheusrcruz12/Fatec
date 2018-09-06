package br.gov.sp.fatec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.MateriaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/MateriaRepositoryTest-context.xml" })
@Transactional
public class MateriaRepositoryTest {
	
	
	
	

	private static final String NOME = "Materia XX";
	private static final int HORA_AULA = 80;
	// Nome do Curso
	private static final String NOME_CURSO = "Curso X";
	
	@Autowired
	private MateriaRepository materiaRepo;
	
	@Autowired
	private CursoRepository cursoRepo;

	public void setUsuarioRepo(MateriaRepository materiaRepo) {
		this.materiaRepo = materiaRepo;
	}

	public void setAutorizacaoRepo(CursoRepository cursoRepository) {
		this.cursoRepo = cursoRepository;
	}
	
	@Test
	public void testeInsercaoCursoOk() {
		Curso curso = new Curso();
		curso.setCurNome(NOME_CURSO);	
		cursoRepo.save(curso);	
		assertNotNull(curso.getId());
	}
	@Test
	public void testeInsercaoOk() {
		Curso curso = new Curso();
		curso.setCurNome(NOME_CURSO);
		cursoRepo.save(curso);
		Materia materia = new Materia();
		materia.setMatNome(NOME);
		materia.setMatHorasSem(HORA_AULA);
		
		materia.setCurso(curso);
		materiaRepo.save(materia);
		assertNotNull(materia.getMatId());
	}
	
	@Test
	public void testeBuscaOk() {
		//Salvando curso
		Curso curso = new Curso();
		curso.setCurNome(NOME_CURSO);
		cursoRepo.save(curso);
		//Salvando materia
		Materia materia = new Materia();
		materia.setMatNome(NOME);
		materia.setMatHorasSem(HORA_AULA);
		
		materia.setCurso(curso);
		materiaRepo.save(materia);
		Materia mat = new Materia();
		mat = materiaRepo.findByMatNome(NOME);
		
		assertTrue(mat.getMatNome().equals(NOME));
	}
	@Test
	public void testeDeleteOk() {
		//Salvando curso
		Curso curso = new Curso();
		curso.setCurNome(NOME_CURSO);
		cursoRepo.save(curso);
		//Salvando materia
		Materia materia = new Materia();
		materia.setMatNome(NOME);
		materia.setMatHorasSem(HORA_AULA);
		
		materia.setCurso(curso);
		materiaRepo.save(materia);
		Materia mat = new Materia();
		mat = materiaRepo.findByMatNome(NOME);
		
		materiaRepo.delete(materiaRepo.findByMatNome(NOME));
		//materia = materiaRepo.findByMatNome(NOME);
		//System.out.println(materia.getMatNome());
		assertNull(materia.getMatNome());
	}

}
