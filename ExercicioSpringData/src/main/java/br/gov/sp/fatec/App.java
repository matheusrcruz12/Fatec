package br.gov.sp.fatec;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Materia;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.MateriaRepository;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.service.MateriaService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(	"applicationContext.xml");
 
	/*	AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DIConfig.class);
		*/
	
		// Recupera os repositorios
		MateriaRepository materiaRepo = (MateriaRepository) context.getBean("materiaRepository");
		CursoRepository cursoRepo = (CursoRepository) context.getBean("cursoRepository");
		
		
		
		//Criando Materiass
		MateriaService materiaService = (MateriaService)context.getBean("materiaService");
		

		// Cria um Cursos
		Curso curso = new Curso();
		
		// Cria usuario usando servico (FORMA CORRETA DE FAZER!)
		CursoService cursoService = (CursoService)context.getBean("cursoService");
		/*try {
			curso = cursoService.incluirCurso("Banco de Dados");
		}catch(Exception e) {
			System.out.println("Erro ao inserir Materia!!");
		}*/		
		try {
			curso = cursoService.incluirCurso("BD");
		}catch(Exception e) {
			System.out.println("Erro ao inserir Curso!!");
		}
		Materia materia = new Materia();
		try {
			materia = materiaService.incluirMateria("Estrutura de Dados", 80,curso);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			materia = materiaService.incluirMateria("Algoritmo", 80,curso);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			materia = materiaService.incluirMateria("Ingles I", 40,curso);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			materia = materiaService.incluirMateria("Lab 4", 80,curso);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		System.out.println("Materia Add "+materia.getMatNome()+" no Curso de "+curso.getCurNome());
		System.out.println("Id: " + curso.getId());
		
		// Realiza varias consultas
		//System.out.println("Resultado da busca 1: " + cursoRepo.findByCurNome("BD").getCurNome());
		
		//System.out.println("Resultado da busca 2: " + cursoRepo.findTop1ByCurNomeContains("B").getCurNome());

		for(Curso cso: cursoRepo.findByIdGreaterThan(0l)) {
			System.out.println("Curso encontrado: " + cso.getCurNome());
		}
		
		/*
		for(Curso cso: cursoRepo.findByNomeContainsIgnoreCaseOrMateriasNomeContainsIgnoreCase("n", "m")) {
			System.out.println("Curso encontrado 2 (or): " + cso.getCurNome());
		}
		
		for(Curso cso: cursoRepo.findByMateriasNomeContainsIgnoreCase("Curso")) {
			System.out.println("Usuario encontrado 3: " + cso.getCurNome());
		}
	*/	
		for(Curso cso: cursoRepo.buscaCurso("a")) {
			System.out.println("Usuario encontrado 4: " + cso.getCurNome());
		}
		
		// Gerando erro de proposito ao tentar criar dois usuarios com mesmo nome
		try {
			//cursoService.incluirMateria("");
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}
		
		// Mesmo o erro ocorrendo somente no segundo insert, nada se grava por conta da transacao
		curso = cursoRepo.findByCurNome("ADS");
		if(curso == null) {
			System.out.println("Curso de ADS nao foi encontrado!");
		}else 
			System.out.println("Opa temos o curso de "+curso.getCurNome());
		
		curso = cursoRepo.findByCurNome("BD");
		if(curso == null) {
			System.out.println("Curso de ADS nao foi encontrado!");
		}else 
			System.out.println("Opa temos o curso de "+curso.getCurNome());
		
		// Excluir Materias
		//materiaRepo.delete(materiaRepo.findByMatNome("Algoritmo"));
		materiaRepo.delete(materiaRepo.findByMatNome("Estrutura de Dados"));
		materiaRepo.delete(materiaRepo.findByMatNome("Ingles I"));
		materiaRepo.delete(materiaRepo.findByMatNome("Lab 4"));
		
		// Exclui cursos
		cursoRepo.delete(cursoRepo.findByCurNome("BD"));
		
		context.close();

    }
}
