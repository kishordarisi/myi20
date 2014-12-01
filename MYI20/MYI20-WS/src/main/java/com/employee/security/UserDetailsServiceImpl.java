/**
 * Created on 08-Aug-2013
 */
package com.employee.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.business.Role;
import com.employee.dao.UserDAO;

/**
 * @author rajashekar
 *
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class);

    /**
     *
     * @return
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     *
     * @param userDAO
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     * @throws DataAccessException
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        try {
            LOGGER.debug("User name : "
                    + new String(username.getBytes("UTF-8"), Charset
                            .forName("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("while getting user name ", e);
        }

        com.employee.business.UserAccount user = userDAO
                .findByNameILike(username);
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            LOGGER.debug("roles are" + role.getName());
            authorities.add(new GrantedAuthorityImpl(role.getName()));
        }

        String dbsalt = user.getUserName().substring(0,3);
        LOGGER.info("dbsalt" + dbsalt);
        ShaPasswordEncoder sha = new ShaPasswordEncoder(512);
        sha.encodePassword(user.getPassword(), dbsalt);

        UserDetails userDetails = new CustomUserDetails(user.getUserName(),
                user.getPassword(), user.getEnabled(), true, true,
                user.getAccountNotLocked(), authorities, dbsalt);

        return userDetails;
    }
}