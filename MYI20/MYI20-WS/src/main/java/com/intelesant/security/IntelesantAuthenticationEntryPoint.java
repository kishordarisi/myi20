/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelesant.security;

import com.intelesant.business.UserAccount;
import com.intelesant.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * 
 * @author ramesh
 */
public class IntelesantAuthenticationEntryPoint extends
        BasicAuthenticationEntryPoint {

    private static final Logger LOGGER = Logger
            .getLogger(IntelesantAuthenticationEntryPoint.class);
    /**
     *
     */
    public static final int NOT_ACTIVE = 1001;
    @Autowired
    private UserDAO userDAO;

    /**
     *
     */
    public IntelesantAuthenticationEntryPoint() {
        LOGGER.debug("Entry point constructor called.");
    }

    /**
     * 
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        LOGGER.info("Commmence method.");

        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) authException
                .getAuthentication();
        LOGGER.info(user.getName());
        UserAccount userAccount = userDAO.findByName(user.getName());

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("WWW-Authenticate", "BasicCustom realm=\""
                + getRealmName() + "\"");

        int i = userAccount.getLoginAttempt();

        userAccount.setLoginAttempt(i + 1);

        if (userAccount.getLoginAttempt() >= 3) {
            userAccount.setAccountNotLocked(Boolean.FALSE);
        }
        userDAO.saveOrUpdate(userAccount);
        if (userAccount.getAccountNotLocked()) {
            if (userAccount.getEnabled()) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        authException.getMessage());
            } else {
                httpResponse.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
                        authException.getMessage());
            }
        } else {
            httpResponse.sendError(HttpServletResponse.SC_PRECONDITION_FAILED,
                    authException.getMessage());
        }

    }
}