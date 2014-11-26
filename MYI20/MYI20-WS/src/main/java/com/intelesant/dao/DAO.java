/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelesant.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ramesh
 */
@Component("dao")
public class DAO implements IDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
     *
     * @param <T>
     * @param object
     * @return
     */
    @Override
	public <T extends Serializable> Serializable save(T object) {
		return sessionFactory.getCurrentSession().save(object);
	}

	/**
     *
     * @param <T>
     * @param object
     */
    @Override
	public <T extends Serializable> void update(T object) {

		sessionFactory.getCurrentSession().update(object);
	}

	/**
     *
     * @param <T>
     * @param clazz
     * @param id
     * @return
     */
    @Override
	public <T extends Serializable> T findBy(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	/**
     *
     * @return
     */
    @Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
     *
     * @param <T>
     * @param clazz
     * @return
     */
    @Override
	public <T extends Serializable> List<T> get(Class<T> clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	/**
     *
     * @param <T>
     * @param object
     */
    @Override
	public <T extends Serializable> void delete(T object) {

		sessionFactory.getCurrentSession().delete(object);
	}

	/**
     *
     * @param <T>
     * @param entityName
     * @param name
     * @return
     */
    @Override
	public <T extends Serializable> T findObservationBy(String entityName,
			Serializable name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(entityName);
		criteria.add(Restrictions.eq("id", name));
		return (T) criteria.uniqueResult();
	}

	/**
     *
     * @param <T>
     * @param object
     */
    @Override
	public <T extends Serializable> void saveOrUpdate(T object) {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	/**
     *
     * @param <T>
     * @param clazz
     * @param name
     * @return
     */
    @Override
	public <T extends Serializable> T findByName(Class<T> clazz,
			Serializable name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				clazz);
		criteria.add(Restrictions.eq("idName.name", name));
		return (T) criteria.uniqueResult();
	}

}