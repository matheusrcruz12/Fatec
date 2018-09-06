package br.gov.sp.fatec;

import static org.junit.Assert.assertFalse;
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

import br.gov.sp.fatec.service.MateriaService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class MateriaServiceTest {
	
	private static final String NOME = "Usuário X";
	private static final int HORAS = 80;
	private Curso curso;
	@Autowired
	private CursoRepository cursoRepo;
	
	@Autowired
	private MateriaRepository materiaRepo;
	
	@Autowired
	private MateriaService materiaService;
	
	public void setMateriaRepo(MateriaRepository materiaRepo) {
		this.materiaRepo = materiaRepo;
	}
	
	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

	@Test
	public void testeIncluirUsuarioOk() {
		curso = new Curso();
		curso.setCurNome("ADS");
		cursoRepo.save(curso);
		materiaService.incluirMateria(NOME, HORAS, curso);
		Materia mat = new Materia();
		mat = materiaRepo.findByMatNome(NOME);
		assertTrue(mat.getMatNome().equals(NOME));
		
	}

}
