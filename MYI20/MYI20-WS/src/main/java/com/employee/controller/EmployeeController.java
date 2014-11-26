/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.employee.controller;

import com.properties.PropBean;
import com.employee.util.FileUploaderUtil;
import com.intelesant.dto.ImageDTO;
import com.intelesant.service.UserService;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
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
    
}
