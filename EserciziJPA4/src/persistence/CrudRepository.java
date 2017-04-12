package persistence;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


public interface CrudRepository<T> {

	public T Save(T entity) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public T FindOne(Long id);
	
	public List<T> FindAll();
	
	public void Delete(T entity);
	
	public void DeleteAll();
}
