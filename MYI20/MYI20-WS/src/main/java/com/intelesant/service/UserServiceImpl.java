package com.intelesant.service;

import com.intelesant.dao.DAO;
import com.intelesant.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelesant.builder.UserBuilder;
import com.intelesant.business.UserAccount;
import com.intelesant.dao.UserDAO;
import com.intelesant.dto.ImageDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import org.apache.log4j.Logger;


@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
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
    
    
    
    @Override
    public ImageDTO getUserLogo(String imagePath) {
        ImageDTO logoDTO = new ImageDTO();
        FileInputStream fis = null;
        ByteArrayOutputStream bos=null;
        LOGGER.info("image path in getting logo method :" + imagePath);
        try {
            File file = new File(imagePath);
            LOGGER.info("image exists: " + file.exists() + " !!");
            if (!file.exists()) {
                LOGGER.info("image does not exist");
                return null;
            }
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] image = new byte[(int) file.length()];

            for (int readNum; (readNum = fis.read(image)) != -1;) {
                bos.write(image, 0, readNum);
            }

            logoDTO.setImage(bos.toByteArray());
            int index ;
//			String imageName = imagePath.substring(index + 1);
            logoDTO.setImagePath(imagePath);

            index = imagePath.lastIndexOf(".");
            logoDTO.setFileExtension(imagePath.substring(index) + 1);

            LOGGER.info("file after reading: " + bos.size());
        } catch (IOException ex) {
            LOGGER.error("unable to read iamge", ex);
        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
            LOGGER.error("unable to read iamge", e);
            }

        }
        return logoDTO;
    }

    @Override
    public ImageDTO updateUser(UserAccountDTO userAccountDTO) {
        UserAccount userAccount=userDAO.findByNameILike(userAccountDTO.getUserName());
        userAccount.setFirstName(userAccountDTO.getFirstName());
        userAccount.setLastName(userAccountDTO.getLastName());
        if(userAccountDTO.getPhotoURL()!=null){
        userAccount.setPhotoURL(userAccountDTO.getPhotoURL());
        }
        dao.saveOrUpdate(userAccount);
        ImageDTO imageDTO=userAccount.getPhotoURL()!=null?getUserLogo(userAccount.getPhotoURL()):new ImageDTO();
        return imageDTO;
    }
    
    @Override
    public String getFileName(String imgName) {
        String fileName = null;
        if (imgName != null) {
            int i = imgName.lastIndexOf('/');
            if (i > 0) {
                fileName = imgName.substring(i + 1);

            }
        }
        return fileName;
    }

}
