package com.employee.dao;

import com.employee.business.Feature;
import com.employee.business.Role;
import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.employee.business.UserAccount;
import java.util.List;

/**
 *
 * @author ramulu
 */
@Service
public interface UserDAO extends IDAO {

	/**
     *
     * @param id
     * @return
     */
    UserAccount findById(String id);

	/**
     *
     * @param userName
     * @return
     */
    UserAccount findByName(String userName);

	/**
     *
     * @param user
     * @return
     */
    Serializable save(UserAccount user);

	/**
     *
     * @param user
     */
    void saveOrUpdate(UserAccount user);

	/**
     *
     * @return
     */
    SessionFactory getSessionFactory();

	/**
     *
     * @param sessionFactory
     */
    void setSessionFactory(SessionFactory sessionFactory);


	/**
     *
     * @param role
     * @return
     */
    Role findByRoleName(String role);

	/**
     *
     * @param email
     * @return
     */
    UserAccount findUserAccount(String email);

	/**
     *
     * @param name
     * @return
     */
    List<UserAccount> searchListOfUserByName(String name);

	/**
     *
     * @param userName
     * @return
     */
    UserAccount findByNameILike(String userName);
    
    List<UserAccount> getOrgAccounts();
    
    Feature findByFeatureName(String featureName);
}