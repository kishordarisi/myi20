package com.intelesant.service;

import com.intelesant.dao.DAO;
import com.intelesant.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelesant.builder.UserBuilder;
import com.intelesant.dao.UserDAO;
import java.security.Principal;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	DAO dao;
	@Autowired
	UserBuilder userBuilder;
        
        @Autowired
        UserDAO userDAO;
        
        

	@Transactional
        @Override
	public void addUser(UserAccountDTO userAccountDTO) {
		// TODO Auto-generated method stub
		dao.save(userBuilder.convertTOUser(userAccountDTO));
	}

    @Override
    public UserAccountDTO login(Principal principal) {
        return userBuilder.convertTOUserDTO(userDAO.findByNameILike(principal.getName()));
    }

    @Override
    public UserAccountDTO getUserDetails(String userName) {
        return userBuilder.convertTOUserDTO(userDAO.findByNameILike(userName));
    }

}
