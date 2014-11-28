/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.employee.controller;

import com.properties.PropBean;
import com.employee.util.FileUploaderUtil;
import com.intelesant.dto.ImageDTO;
import com.intelesant.dto.UserAccountDTO;
import com.intelesant.service.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author kishor
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);
    @Autowired
    private PropBean propBean;
    
    @Autowired
    private UserService userService;
    
    /**
	 * 
	 * @param request
	 * @param response
     * @return 
	 */
	@RequestMapping(value = "/uploadLogo", method = RequestMethod.POST)
	@ResponseBody
	public String uploadOrganizationLogo(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		String returnValue = null;
		HttpHeaders headers = request.getRequestHeaders();

		LOGGER.info("Request headers");
		for (String key : headers.keySet()) {
			LOGGER.info("Key = " + key + " value = " + headers.values());
		}

		Iterator<String> itr = request.getFileNames();
		LOGGER.info("file in file Upload controller: "+itr.toString().length());
		LOGGER.info("Request File Names: " + request.getFileNames().hasNext());
		if (itr.hasNext()) {
			String file = itr.next();

			LOGGER.info("File URL is : " + file);
			MultipartFile mpf = request.getFile(file);

			LOGGER.info("Uploaded file");

			                 FileUploaderUtil util = new FileUploaderUtil();
			
				returnValue = util.uploadOrganizationLogo(mpf, propBean);
			
		}
		return returnValue;
	}
        
        @RequestMapping(value = "/userLogo", params = { "imagePath" }, method = RequestMethod.GET)
	public @ResponseBody
	ImageDTO getOrganizationLogo(@RequestParam String imagePath) {
		return userService.getUserLogo(imagePath);

	}
        
        @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody void registerUser(@RequestBody UserAccountDTO userAccountDTO) {

            userService.addUser(userAccountDTO);
    }
    
    @RequestMapping(value = "/getUser",params="userName", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody UserAccountDTO getUserDetails(@RequestParam String userName) {

          return  userService.getUserDetails(userName);
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody void updateUser(@RequestBody UserAccountDTO userAccountDTO) {

            userService.updateUser(userAccountDTO);
    }
    
    @RequestMapping(value = "/download_file", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    void downloadDocument(String filePath, HttpServletResponse response)
            throws IOException {

        String fileName = userService.getFileName(filePath);
        InputStream fileInputStream = null;
        PrintWriter printWriter = null;
        try {
            LOGGER.info("inside try");
            File downloadFile = new File(filePath);
            String filename = downloadFile.getName();
            LOGGER.info("the file name is " + filename);
            int fileSize = (int) downloadFile.length();
            LOGGER.info("the file name is " + fileSize);
            fileInputStream = new FileInputStream(downloadFile);
            response.setHeader("Content-Disposition", "attachment;filename="
                    + "\"" + fileName + "\"");
            printWriter = response.getWriter();
            int charcter = -1;
            // Loop to read and write bytes.
            while ((charcter = fileInputStream.read()) != -1) {
                printWriter.print((char) charcter);
            }

        } catch (FileNotFoundException exception) {
            LOGGER.error("File not found", exception);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
    
    
    /**
	 * 
     * @param userName
	 * @param request
	 * @param response
     * @return 
	 */
	@RequestMapping(value = "/uploadDocs/{userName}", method = RequestMethod.POST)
	@ResponseBody
	public String uploadDocs(@PathVariable("userName") String userName,MultipartHttpServletRequest request,
			HttpServletResponse response) {
		String returnValue = null;
		HttpHeaders headers = request.getRequestHeaders();

		LOGGER.info("Request headers");
		for (String key : headers.keySet()) {
			LOGGER.info("Key = " + key + " value = " + headers.values());
		}

		Iterator<String> itr = request.getFileNames();
		LOGGER.info("file in file Upload controller: "+itr.toString().length());
		LOGGER.info("Request File Names: " + request.getFileNames().hasNext());
                int i=0;
		if (itr.hasNext()) {
			String file = itr.next();

			LOGGER.info("File URL is : " + file);
			MultipartFile mpf = request.getFile(file);

			LOGGER.info("Uploaded file");

			       FileUploaderUtil util = new FileUploaderUtil();
			if(i==0){
                            returnValue=util.uploadOrganizationLogo(mpf, propBean);
                        }else{
			    returnValue = returnValue+","+util.uploadOrganizationLogo(mpf, propBean);
                        }
			
		}
		return returnValue;
	}
    
}
