package persistence.JPA;

import java.util.List;

import javax.persistence.*;

import model.Stanza;

public class StanzaCrudRepositoryJPA extends CrudRepositoryJPA<Stanza> {

	public StanzaCrudRepositoryJPA(EntityManager em) {
		super(em, Stanza.class);
	}
	
	public List<Stanza> findStanzaByPiano(String piano){
		TypedQuery<Stanza> query = getEm().createQuery("SELECT s FROM Stanza s WHERE s.piano = " + piano, Stanza.class);
		return query.getResultList();
	}
}
