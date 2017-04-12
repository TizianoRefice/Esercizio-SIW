package model;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.persistence.*;

import persistence.CrudRepository;
import persistence.JPA.CrudRepositoryJPA;

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
				
		CrudRepository<Artista> crudRepA = new CrudRepositoryJPA<Artista>(em, Artista.class);
		CrudRepository<Opera> crudRepO = new CrudRepositoryJPA<>(em, Opera.class);
									
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		crudRepA.Save(a);
		crudRepO.Save(o);
		tx.commit();
		em.close();
		emf.close();
	
		
		
	}
	
}
