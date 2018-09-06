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
import javax.persistence.Table;
@Entity
@Table(name = "fac_faculdade")
public class Faculdade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fac_id")
	private Long facId;
	@Column(name = "fac_nome", unique=true, length = 20, nullable = false)
	private String facNome;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "fco_faculdade_curso", 
		joinColumns = { @JoinColumn(name = "fac_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "cur_id") })
	private List<Curso> cursos;
	
	public Long getFacId() {
		return facId;
	}
	public void setFacId(Long facId) {
		this.facId = facId;
	}
	public String getFacNome() {
		return facNome;
	}
	public void setFacNome(String facNome) {
		this.facNome = facNome;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
