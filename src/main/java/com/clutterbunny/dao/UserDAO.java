/**
 * 
 */
package com.clutterbunny.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.clutterbunny.domain.User;

/**
 * 
 * @author knagamalla
 */
@Service
public class UserDAO extends BaseDAO {
	
	public void save(User user) {
		user.setCreatedTime(new Date());
		user.setLastModifiedTime(user.getCreatedTime());
		
		persist(user);
	}
	
	
	public User findByMobile(String mobileNumber) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> runRoot = cq.from(User.class);
		cq.select(runRoot);
		
		cq.where(cb.equal(runRoot.get("mobileNumber"), mobileNumber));
	
		List<User> users = entityManager.createQuery(cq).getResultList();
		
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	public User findBySsn(String ssn) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> runRoot = cq.from(User.class);
		cq.select(runRoot);
		
		cq.where(cb.equal(runRoot.get("ssn"), ssn));
	
		List<User> users = entityManager.createQuery(cq).getResultList();
		
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	
	public User findByUser(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> runRoot = cq.from(User.class);
		cq.select(runRoot);
		
		cq.where(cb.equal(runRoot.get("username"), username));
	
		List<User> users = entityManager.createQuery(cq).getResultList();
		
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	
	public User verifyLogin(String mobileNumber, String password) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> userRoot = cq.from(User.class);
		cq.select(userRoot);
		
		cq.where(cb.and(cb.equal(userRoot.get("mobileNumber"), mobileNumber), cb.equal(userRoot.get("password"), password)));
	
		List<User> users = entityManager.createQuery(cq).getResultList();
		
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
}
