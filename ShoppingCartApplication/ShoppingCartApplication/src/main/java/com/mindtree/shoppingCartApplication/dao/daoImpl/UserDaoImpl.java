package com.mindtree.shoppingCartApplication.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingCartApplication.dao.UserDao;
import com.mindtree.shoppingCartApplication.model.User;
import com.mindtree.shoppingCartApplication.repository.UserRepository;
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;

	@Override
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

}
