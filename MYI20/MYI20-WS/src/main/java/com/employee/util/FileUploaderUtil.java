
package com.employee.util;
import com.properties.PropBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kishor
 */
public class FileUploaderUtil {
    
    private static final Logger LOGGER = Logger
            .getLogger(FileUploaderUtil.class);
    
    
    public String uploadOrganizationLogo(MultipartFile mpf, PropBean propBean) {
        String fileReturnValue = null;
        FileOutputStream fos = null;
        String fileName;
        String filePath;
        try {
            LOGGER.info("prop object" + propBean);
            filePath = propBean.getPropData().get("imageLocation").toString();
            LOGGER.info("image location" + filePath);

            fileName = mpf.getOriginalFilename();

            if (!mpf.isEmpty()) {
                byte[] bytes = mpf.getBytes();
                LOGGER.debug("after get bytes");
                LOGGER.info("file path and name" + filePath + fileName);
                File someFile = new File(filePath);
                boolean flag = someFile.mkdirs();
                LOGGER.info("Image directory created :: " + flag);
                File file = new File(someFile, fileName);
                LOGGER.info("file created: " + file);
                fos = new FileOutputStream(file);
                fos.write(bytes);
                fos.flush();
                LOGGER.info("success fully uploaded");
                fileReturnValue = filePath + fileName;
            }

        }catch(Exception e){
        LOGGER.error(e.getMessage());
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ie) {
                LOGGER.error(ie.getMessage(), ie);
            }

        }

        return fileReturnValue;
    }
    
}
