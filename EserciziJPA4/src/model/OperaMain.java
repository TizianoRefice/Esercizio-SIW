package model;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.persistence.*;

import persistence.CrudRepository;
import persistence.JPA.*;

public class OperaMain {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("orders-unit");
		EntityManager em = emf.createEntityManager();
		
		Artista a = new Artista();
		a.setNome("pablo");
		
		Opera o = new Opera();
		o.setTitolo("il cazzo che me ne frega");
		List<Artista> artisti = new ArrayList<Artista>();
		artisti.add(a);
		o.setArtisti(artisti);
		
		Stanza n11 = new Stanza();
		n11.setNome("N11");
		n11.setPiano("terra");
		List<Opera> opere = new ArrayList<Opera>();
		opere.add(o);
		n11.setOpereInStanza(opere);
		
		Stanza n12 = new Stanza();
		n12.setNome("N12");
		n12.setPiano("primo");
		
		Stanza n13 = new Stanza();
		n13.setNome("N13");
		n13.setPiano("terra");
		
		Curatore cur = new Curatore();
		cur.setNome("Giovanni");
		List<Stanza> stanzeCurate = new ArrayList<Stanza>();
		stanzeCurate.add(n13);
		stanzeCurate.add(n12);
		cur.setStanzeCurate(stanzeCurate);
		
		n13.setCuratore(cur);
		n12.setCuratore(cur);
				
		CrudRepository<Artista> crudRepA = new CrudRepositoryJPA<Artista>(em, Artista.class);
		CrudRepository<Opera> crudRepO = new CrudRepositoryJPA<>(em, Opera.class);
		CrudRepository<Stanza> crudRepS = new CrudRepositoryJPA<>(em, Stanza.class);
		CrudRepository<Curatore> crudRepC = new CrudRepositoryJPA<>(em, Curatore.class);
		
		StanzaCrudRepositoryJPA sJPA = new StanzaCrudRepositoryJPA(em);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		crudRepA.Save(a);
		crudRepO.Save(o);
		crudRepS.Save(n13);
		crudRepS.Save(n12);
		crudRepS.Save(n11);
		crudRepC.Save(cur);
		tx.commit();
		em.close();
		emf.close();
	
		
		
	}
	
}
