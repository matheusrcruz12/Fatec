package br.gov.sp.fatec.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.MateriaRepository;
@Service("cursoService")
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository cursoRepo;
	
	@Autowired
	private MateriaRepository materiaRepo;
	
	@Override
	@Transactional
	public Curso incluirCurso(String nome) {
		
		Curso curso = new Curso();
		curso.setCurNome(nome);
		
		curso.setMaterias(new ArrayList<Materia>());
		cursoRepo.save(curso);
		return curso;
		
	}

	@Override
	@Transactional
	public Materia incluirMateria(String nome, String nomeCurso) {
		Materia materia = materiaRepo.findByMatNome(nome);
		Curso curso = cursoRepo.findByCurNome(nomeCurso);
		// Se nao existe
		if(materia == null) {
			// Cria nova
			materia = new Materia();
			materia.setMatNome(nome);
			materiaRepo.save(materia);
		}
		if(curso == null) {
			curso = new Curso();
			curso.setCurNome(nomeCurso);
		}
		
		curso.setMaterias(new ArrayList<Materia>());
		curso.getMaterias().add(materia);
		cursoRepo.save(curso);
		return materia;
		
	}

	/**
	 * @param cursoRepo the cursoRepo to set
	 */
	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}
	
	/**
	 * @param materiaRepo the materiaRepo to set
	 */
	public void setMateriaRepo(MateriaRepository materiaRepo) {
		this.materiaRepo = materiaRepo;
	}

}
