/**
 * 
 */
package com.clutterbunny.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.clutterbunny.domain.BookRegistry;

/**
 * 
 * @author knagamalla
 */
@Service
public class BookRegistryDAO extends BaseDAO {
	
	public void save(BookRegistry user) {
		user.setCreatedTime(new Date());
		user.setLastModifiedTime(user.getCreatedTime());
		
		persist(user);
	}
	
	public List<BookRegistry> getBooksByEmail(Long userId) {
		Query q = entityManager
				.createQuery("SELECT u FROM BookRegistry u where u.userId = :userId");
		q.setParameter("userId", userId);
		return findList(BookRegistry.class, q);
	}
	
	public List<BookRegistry> searchBooks(String kw) {
		Query q = entityManager
				.createQuery("SELECT u FROM BookRegistry u where u.name like :name or u.isbnNumber like :isbnNumber");
		q.setParameter("isbnNumber", "%"+kw+"%");
		q.setParameter("name", "%"+kw+"%");
		return findList(BookRegistry.class, q);
	}
	
}
