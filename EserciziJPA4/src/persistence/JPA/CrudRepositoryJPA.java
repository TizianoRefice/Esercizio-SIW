package persistence.JPA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.*;

import persistence.CrudRepository;


public class CrudRepositoryJPA<T> implements CrudRepository<T> {

	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}
	
	@Override
	public T Save(T entity) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		Method getId = null;
		T persistentEntity = null; // lo usiamo per mantenere la nostra entità managed
		try{
			getId = this.entityClass.getMethod("getId");
		}catch (NoSuchMethodException | SecurityException e){
			e.printStackTrace();
		}
		try{
			if(getId.invoke(entity) == null){
				em.persist(entity);
				persistentEntity = entity;
			} else {
				persistentEntity = em.merge(entity);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}
		

	@Override
	public T FindOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> FindAll() {
		String className = this.entityClass.getSimpleName();
		TypedQuery<T> query = em.createQuery("SELECT e FROM "+ className + " e", this.entityClass);
		return query.getResultList();
	}

	@Override
	public void Delete(Object entity) {
		em.remove(entity);
		
	}

	@Override
	public void DeleteAll() {
		String className = this.entityClass.getCanonicalName();
		Query query = em.createQuery("DELETE FROM" + className);
		query.executeUpdate();
		
	}

	protected EntityManager getEm() {
		return em;
	}
}
