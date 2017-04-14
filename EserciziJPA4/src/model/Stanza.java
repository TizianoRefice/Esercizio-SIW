package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Stanza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	private String piano;
	@OneToMany
	@JoinColumn(name = "id_stanza")
	private List<Opera> opereInStanza;
	@ManyToOne
	private Curatore curatore;
	
	public Curatore getCuratore() {
		return curatore;
	}
	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}
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
	public List<Opera> getOpereInStanza() {
		return opereInStanza;
	}
	public void setOpereInStanza(List<Opera> opereInStanza) {
		this.opereInStanza = opereInStanza;
	}
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		this.piano = piano;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
}
