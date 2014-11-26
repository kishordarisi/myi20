/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.login.security;

import com.intelesant.dao.DAO;
import com.intelesant.dao.UserDAO;
import com.intelesant.dto.UserAccountDTO;
import com.intelesant.service.UserService;
import java.security.Principal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author KITTU
 */
@Controller
@RequestMapping("/secure")
public class LoginController {
    
    private static final Logger LOGGER = Logger
            .getLogger(LoginController.class);
    
     @Autowired
     UserDAO userDAO;
     @Autowired
     DAO dao;
     
     @Autowired
     UserService userService;
    
    /**
     * Used to Login into the system.
     * 
     * @param modelMap
     * @param principal
     * @return UserAccountDTO.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public UserAccountDTO login(ModelMap modelMap, Principal principal) {
        LOGGER.info("User Name  is :::::::::"+principal.getName());
        return userService.login(principal);

    }
    
}