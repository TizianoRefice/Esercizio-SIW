package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date annoNascita;
	@Temporal(TemporalType.DATE)
	private Date annoMorte;
	@ManyToMany(mappedBy = "artisti")
	private List<Opera> opere;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}
	public Date getAnnoMorte() {
		return annoMorte;
	}
	public void setAnnoMorte(Date annoMorte) {
		this.annoMorte = annoMorte;
	}
	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
}
