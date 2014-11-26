package com.intelesant.service;

import com.intelesant.dto.ImageDTO;
import com.intelesant.dto.UserAccountDTO;
import java.security.Principal;


public interface UserService {

	void addUser(UserAccountDTO userAccountDTO);
        
        UserAccountDTO login(Principal principal);
        
        UserAccountDTO getUserDetails(String userName);
        
        public ImageDTO getUserLogo(String imagePath);
}
