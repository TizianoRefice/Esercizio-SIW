package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Curatore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@OneToMany(mappedBy = "curatore")
	private List<Stanza> stanzeCurate;
	
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
	public List<Stanza> getStanzeCurate() {
		return stanzeCurate;
	}
	public void setStanzeCurate(List<Stanza> stanzeCurate) {
		this.stanzeCurate = stanzeCurate;
	}
	
	
	
}
