package com.intelesant.dao;

import com.intelesant.business.Feature;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.intelesant.business.Role;
import com.intelesant.business.UserAccount;


/**
 *
 * @author ramulu
 */
@Component("userDAO")
@Transactional
public class UserDAOImpl extends DAO implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public UserAccount findByName(String userName) {
        LOGGER.info("user name in dao" + userName);
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(UserAccount.class);
        criteria.add(Restrictions.eq("userName", userName).ignoreCase());
        LOGGER.info("user name in dao" + userName);
        return (UserAccount) criteria.uniqueResult();
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public Serializable save(UserAccount user) {
        Session session = getSessionFactory().getCurrentSession();
        return session.save(user);
    }

    /**
     *
     * @param user
     */
    @Override
    public void saveOrUpdate(UserAccount user) {
        Session session = getSessionFactory().getCurrentSession();
        LOGGER.debug("user in save or update " + user.getLoginAttempt() + "" + user.getId());
        session.update(user);

        LOGGER.debug("success updated");
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public UserAccount findById(String id) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(UserAccount.class);
        criteria.add(Restrictions.eq("id", id));

        return (UserAccount) criteria.uniqueResult();
    }

    /**
     *
     * @param role
     * @return
     */
    @Override
    public Role findByRoleName(String role) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq("name", role));

        return (Role) criteria.uniqueResult();
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public UserAccount findUserAccount(String email) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(UserAccount.class);
        criteria.add(Restrictions.eq("userName", email).ignoreCase());

        return (UserAccount) criteria.uniqueResult();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<UserAccount> searchListOfUserByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria c = session.createCriteria(UserAccount.class);
        c.createAlias("person", "person");
        c.add(Restrictions.or(
                Restrictions.ilike("person.personalDetails.foreName", name
                        + "%"), Restrictions.ilike("username", name + "%")));
        return c.list();

    }

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public UserAccount findByNameILike(String userName) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(UserAccount.class);
//         criteria.createAlias("organisation", "organisation");
        criteria.add(Restrictions.eq("userName", userName).ignoreCase());
        LOGGER.debug("user name in dao" + userName);
        return (UserAccount) criteria.uniqueResult();
    }

    @Override
    public List<UserAccount> getOrgAccounts() {
        
        
         Session session = getSessionFactory().getCurrentSession();
         String query="FROM UserAccount user WHERE :role in elements(user.roles)";
      return session.createQuery(query).setParameter("role", "ROLE_ORGANIZATION_ADMIN").list();
     
        
    }
    
    @Override
    public Feature findByFeatureName(String featureName){
        
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Feature.class);
//         criteria.createAlias("organisation", "organisation");
        criteria.add(Restrictions.eq("featureName", featureName).ignoreCase());
        LOGGER.debug("user name in dao" + featureName);
        return (Feature) criteria.uniqueResult();
        
    }
}