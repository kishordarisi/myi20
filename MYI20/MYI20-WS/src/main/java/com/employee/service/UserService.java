package com.employee.service;

import com.employee.dto.ApplyNowDTO;
import com.employee.dto.ImageDTO;
import com.employee.dto.UserAccountDTO;
import java.security.Principal;


public interface UserService {

	void addUser(UserAccountDTO userAccountDTO);
        
        UserAccountDTO login(Principal principal);
        
        UserAccountDTO getUserDetails(String userName);
        
        public ImageDTO getUserLogo(String imagePath);
        
        ImageDTO updateUser(UserAccountDTO userAccountDTO);
        
        public String getFileName(String imgName);
        
        public void applyNow(ApplyNowDTO applyNowDTO,String userName);
}
