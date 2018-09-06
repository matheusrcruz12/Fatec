package br.gov.sp.fatec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;
import br.gov.sp.fatec.repository.MateriaRepository;

@Service("materiaService")
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	private MateriaRepository materiaRepo;
	

	@Override
	@Transactional
	public Materia incluirMateria(String nome, int horas, Curso curso) {
		
		Materia materia = new Materia();
		materia.setMatNome(nome);
		materia.setMatHorasSem(horas);
		materia.setCurso(curso);
		materiaRepo.save(materia);
		
		return materia;
		
	}


	@Override
	public Optional<Materia> findById(Long id) {
		Optional<Materia> materia = materiaRepo.findById(id);
		if(materia  != null)
			return materia;
		else 
			return null;
	}


}
