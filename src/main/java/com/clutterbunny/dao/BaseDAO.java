/**
 * 
 */
package com.clutterbunny.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

/**
 * 
 * @author knagamalla
 * May 5, 2014
 */

public class BaseDAO {
	private static final Logger LOGGER = Logger.getLogger(BaseDAO.class);
	protected EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		entityManager = em;
	}

	public void persist(Object entity) { 
		entityManager.persist(entity); 
		
	} 
	
	public final void remove(Object entity) {
		entityManager.remove(entity);
	}

	public <T extends Object> T merge(T entity) {
		/*if(entity instanceof Course) {
			Course c = (Course)entity;
			courseCache.put(c.getId(), c);
		} else if(entity instanceof Chapter) {
			Chapter chapter = (Chapter)entity;
			List<Chapter> cps = cacheChaptersByCourseId.get(chapter.getCourseId());
			if(cps == null) {
				cps = new ArrayList<Chapter>();
			}
			cps.add(chapter);
		}*/
		return entityManager.merge(entity);
	}

	public void refresh(Object entity) {
		entityManager.refresh(entity);
	}

	public void detach(Object entity) {
		entityManager.detach(entity);
	}

	public <T extends Object> T findById(Class<T> type, Object id) {
		if (id != null) {
			return entityManager.find(type, id);
		} else {
			return null;
		}
	}
	
	public <T extends Object> List<T> findAll(Class<T> type) {
		 return entityManager.createQuery("from " + type.getSimpleName(), type).getResultList();
	}

	public void flush() {
		entityManager.flush();
	}
	public void clear() {
		entityManager.clear();
	}
	public boolean contains(Object entity) {
		return entityManager.contains(entity);
	}
	
	
	public <T extends Object> T findSingle(Class<T> type, Query q) {
		T result = null;
		try {
			result = (T)q.getSingleResult();
		} catch(NoResultException e) {
			
		}
		return result;
	}

	public <T extends Object> T findFirst(Class<T> type, Query q) {
		List<T> result = findList(type, q);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}
	
	public <T extends Object> List<T> findList(Class<T> type, Query q) {
		List<T> result = q.getResultList();
		return result;
	}
	
	public List<Object[]> findList(Query q) {
		List<Object[]> result = q.getResultList();
		return result;
	}
	
	public void delete(Query q) {
		int i = q.executeUpdate();
		if (i <= 0) {
			throw new RuntimeException(q.toString() + " record was not deleted");
		}
	}
	
	public int update(Query q) {
		int i = q.executeUpdate();
		return i;
	}
}
