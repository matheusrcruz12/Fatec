package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "prof_id")
	private long id;
	@Column(name = "prof_nome", unique=true, length = 40, nullable = false)
	private String nome;
	
	@OneToMany
	@Column(name = "mat_nome", unique=true, length = 20, nullable = false)
	private List<Materia> materias;
	
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
