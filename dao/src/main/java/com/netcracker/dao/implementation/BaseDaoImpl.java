/**
 * 
 */
package com.netcracker.dao.implementation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.netcracker.dao.BaseDao;
import com.netcracker.exceptions.DaoException;

/**
 * @author Shevchenko,2016
 *
 */

public class BaseDaoImpl<T> implements BaseDao<T> {
	private static Logger log = Logger.getLogger(BaseDaoImpl.class);

	@Autowired
	protected SessionFactory sessionFactory;

	public BaseDaoImpl() {
	}

	public void delete(T t) throws DaoException {
		log.info("Deleting :" + t);
		try {
			getSession().delete(t);
			log.info("Successfully deleted: " + t);
		} catch (HibernateException e) {
			log.error("Error during delete: " + t.getClass().getName() + " class");
			throw new DaoException(e);
		}
	}

	public void saveOrUpdate(T t) throws DaoException {
		log.info("Saving or updating :" + t);
		try {
			getSession().saveOrUpdate(t);
			log.info("Successfully saved or updated: " + t);
		} catch (HibernateException e) {
			log.error("Error during save or update: " + t.getClass().getName() + "class");
			throw new DaoException(e);
		}
	}

	public T get(Serializable id) throws DaoException {
		log.info("Getting entity by id: " + id);
		T t = null;
		try {
			t = (T) getSession().get(getPersistentClass(), id);
			log.info("Successfully got entity " + t + " by id: " + id);
		} catch (HibernateException e) {
			log.error("Error during get entity by id: " + id);
			throw new DaoException(e);
		}
		return t;
	}

	public Serializable save(T entity) throws DaoException {
		log.info("Saving entity: " + entity);
		try {
			getSession().save(entity);
			log.info("Successfully saved entity: " + entity + " by ");
			// TODO log user ip
		} catch (HibernateException e) {
			log.error("Error during saving entity: " + entity.getClass().getName() + " class");
			throw new DaoException(e);
		}
		return null;
	}

	/*
	 * Return the object of the current session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
