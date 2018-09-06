package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mat_materia")
public class Materia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mat_id")
	private long id;
	@Column(name = "mat_nome", unique=true, length = 20, nullable = false)
	private String matNome;
	@Column(name = "mat_hora_sem", nullable = false)
	private int matHorasSem;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "cur_id", nullable = true)
	private Curso curso;
	
	public long getMatId() {
		return id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setMatId(long matId) {
		this.id = matId;
	}
	public String getMatNome() {
		return matNome;
	}
	public void setMatNome(String matNome) {
		this.matNome = matNome;
	}
	public int getMatHorasSem() {
		return matHorasSem;
	}
	public void setMatHorasSem(int matHorasSem) {
		this.matHorasSem = matHorasSem;
	}
	
	
	
}
