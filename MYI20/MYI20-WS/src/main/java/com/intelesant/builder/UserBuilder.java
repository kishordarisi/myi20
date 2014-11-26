package com.intelesant.builder;

import com.intelesant.business.UserAccount;
import com.intelesant.dto.UserAccountDTO;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;



@Component("userBuilder")
public class UserBuilder {

	public UserAccount convertTOUser(UserAccountDTO userAccountDTO){
		UserAccount user=new UserAccount();
		user.setComments(userAccountDTO.getComments());
		user.setFirstName(userAccountDTO.getFirstName());
		user.setLastName(userAccountDTO.getLastName());
                String dbsalt = userAccountDTO.getUserName().substring(0, 3);
                ShaPasswordEncoder sha = new ShaPasswordEncoder(512);
		user.setPassword(sha.encodePassword(userAccountDTO.getPassword(), dbsalt));
		user.setUserName(userAccountDTO.getUserName());
                user.setMobileNumber(userAccountDTO.getMobileNumber());
                user.setPromoCode(userAccountDTO.getPromoCode());
                user.setCountry(userAccountDTO.getCountry());
                user.setAccountNotLocked(Boolean.TRUE);
                user.setEnabled(Boolean.TRUE);
                user.setLoginAttempt(0);
                
		return user;
		
	}
        
        public UserAccountDTO convertTOUserDTO(UserAccount userAccount){
		UserAccountDTO userDTO=new UserAccountDTO();
		userDTO.setComments(userAccount.getComments());
		userDTO.setFirstName(userAccount.getFirstName());
		userDTO.setLastName(userAccount.getLastName());
                userDTO.setUserName(userAccount.getUserName());
                userDTO.setMobileNumber(userAccount.getMobileNumber());
                userDTO.setPromoCode(userAccount.getPromoCode());
                userDTO.setCountry(userAccount.getCountry());
                
		return userDTO;
		
	}
}
