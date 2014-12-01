/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ramesh
 */
@Service
public interface IDAO {

    /**
     * 
     * @param <T>
     * @param object
     * @return
     */
    public <T extends Serializable> Serializable save(T object);

    /**
     * 
     * @param <T>
     * @param object
     */
    public <T extends Serializable> void saveOrUpdate(T object);

    /**
     * 
     * @param <T>
     * @param object
     */
    public <T extends Serializable> void update(T object);

    /**
     * 
     * @param <T>
     * @param clazz
     * @param id
     * @return
     */
    public <T extends Serializable> T findBy(Class<T> clazz, Serializable id);

    /**
     * 
     * @param <T>
     * @param entityName
     * @param name
     * @return
     */
    public <T extends Serializable> T findObservationBy(String entityName,
            Serializable name);

    /**
     * 
     * @return
     */
    public SessionFactory getSessionFactory();

    /**
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public <T extends Serializable> List<T> get(Class<T> clazz);

    /**
     * 
     * @param <T>
     * @param object
     */
    public <T extends Serializable> void delete(T object);

    /**
     * 
     * @param <T>
     * @param clazz
     * @param name
     * @return
     */
    public <T extends Serializable> T findByName(Class<T> clazz,
            Serializable name);
}