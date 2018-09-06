package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "cur_curso")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cur_id")
	private Long id;
	@Column(name = "cur_nome", unique =true, length = 20, nullable = false)
	private String curNome;
	
/*	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cma_curso_materia", 
    	joinColumns = { @JoinColumn(name = "cur_id") }, 
    	inverseJoinColumns = { @JoinColumn(name = "mat_id") })
*/	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	private List<Materia> materias;

	public Long getId() {
		return id;
	}

	public void setCurId(Long curId) {
		this.id = curId;
	}

	public String getCurNome() {
		return curNome;
	}

	public void setCurNome(String curNome) {
		this.curNome = curNome;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
}
