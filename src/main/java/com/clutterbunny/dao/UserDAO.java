/**
 * 
 */
package com.clutterbunny.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.clutterbunny.domain.User;
import com.clutterbunny.domain.UserStatusEnum;

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
	
	public User getUserByEmail(String email) {
		Query q = entityManager
				.createQuery("SELECT u FROM User u where u.email = :email");
		q.setParameter("email", email);
		return findFirst(User.class, q);
	}
	
	
	public List<User> getUsersByStatus(UserStatusEnum status) {
		return null;
	}
	
}
