/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.security;

import com.employee.business.UserAccount;
import com.employee.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ramesh
 */
@Transactional
public class SuccessFullAuthentication extends BasicAuthenticationFilter {

    @Autowired
    private UserDAO userDAO;
    private static final Logger LOGGER = Logger
            .getLogger(SuccessFullAuthentication.class);

    /**
     *
     */
    public SuccessFullAuthentication() {
        LOGGER.info("successfull Authentication object is created");
    }

    /**
     *
     * @param request
     * @param response
     * @param authResult
     */
    @Override
    protected void onSuccessfulAuthentication(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            Authentication authResult) {
        LOGGER.info("on success authentication method called");
        UserAccount user = userDAO.findByName(authResult.getName());
        
        if (user.getLoginAttempt() <3  && user.getLoginAttempt() > 0) {
            LOGGER.info("ur login attempts reset");
            user.setLoginAttempt(0);
            userDAO.saveOrUpdate(user);
        }
    }
}