/**
 * 
 */
package com.clutterbunny.dao;

import java.util.Date;
import java.util.List;

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
	
	
	public List<User> getUsersByStatus(UserStatusEnum status) {
		return null;
	}
	
}
