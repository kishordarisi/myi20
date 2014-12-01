package com.employee.builder;

import com.employee.business.ApplyNow;
import com.employee.business.UserAccount;
import com.employee.dto.ApplyNowDTO;
import com.employee.dto.UserAccountDTO;
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
                userDTO.setPhotoURL(userAccount.getPhotoURL());
                userDTO.setApplyNowDTO(userAccount.getApplication()!=null?createApplyNowDTO(userAccount.getApplication()):new ApplyNowDTO());
                
		return userDTO;
		
	}
        
        public ApplyNowDTO createApplyNowDTO(ApplyNow applyNowDTO){
        
            ApplyNowDTO applyNow=new ApplyNowDTO();
            applyNow.setGraduationLevel(applyNowDTO.getGraduationLevel());
            applyNow.setDegreeCourse(applyNowDTO.getDegreeCourse());
            applyNow.setCountryId(applyNowDTO.getCountryId());
            applyNow.setStudyType(applyNowDTO.getStudyType());
            applyNow.setMonth(applyNowDTO.getMonth());
            applyNow.setYear(applyNowDTO.getYear());
            applyNow.setPrefCountry1(applyNowDTO.getPrefCountry1());
            applyNow.setPrefCountry2(applyNowDTO.getPrefCountry2());
            applyNow.setPrefCountry3(applyNowDTO.getPrefCountry3());
            applyNow.setPrefCountry4(applyNowDTO.getPrefCountry4());
            applyNow.setPrefCountry5(applyNowDTO.getPrefCountry5());
            applyNow.setPrefCountry6(applyNowDTO.getPrefCountry6());
            applyNow.setSsc(applyNowDTO.getSsc());
            applyNow.setInter(applyNowDTO.getInter());
            applyNow.setDegree(applyNowDTO.getDegree());
            applyNow.setCourse1(applyNowDTO.getCourse1());
            applyNow.setCourse2(applyNowDTO.getCourse2());
            applyNow.setPhoto(applyNowDTO.getPhoto());
            return applyNow;
        }
        public ApplyNow createApplyNowEntity(ApplyNowDTO applyNowDTO){
        
            ApplyNow applyNow=new ApplyNow();
            applyNow.setGraduationLevel(applyNowDTO.getGraduationLevel());
            applyNow.setDegreeCourse(applyNowDTO.getDegreeCourse());
            applyNow.setCountryId(applyNowDTO.getCountryId());
            applyNow.setStudyType(applyNowDTO.getStudyType());
            applyNow.setMonth(applyNowDTO.getMonth());
            applyNow.setYear(applyNowDTO.getYear());
            applyNow.setPrefCountry1(applyNowDTO.getPrefCountry1());
            applyNow.setPrefCountry2(applyNowDTO.getPrefCountry2());
            applyNow.setPrefCountry3(applyNowDTO.getPrefCountry3());
            applyNow.setPrefCountry4(applyNowDTO.getPrefCountry4());
            applyNow.setPrefCountry5(applyNowDTO.getPrefCountry5());
            applyNow.setPrefCountry6(applyNowDTO.getPrefCountry6());
            applyNow.setSsc(applyNowDTO.getSsc());
            applyNow.setInter(applyNowDTO.getInter());
            applyNow.setDegree(applyNowDTO.getDegree());
            applyNow.setCourse1(applyNowDTO.getCourse1());
            applyNow.setCourse2(applyNowDTO.getCourse2());
            applyNow.setPhoto(applyNowDTO.getPhoto());
            return applyNow;
        }
}
