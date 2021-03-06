package br.com.jangada.dao;
// Generated 11/09/2016 22:05:50 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import br.com.jangada.bd.Logs;

/**
 * Home object for domain model class Logs.
 * @see br.com.jangada.dao.Logs
 * @author Hibernate Tools 
 */
public class LogsDAO {

	private static final Log log = LogFactory.getLog(LogsDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Logs transientInstance) {
		log.debug("persisting Logs instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			sessionFactory.getCurrentSession().beginTransaction().commit();
			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Logs instance) {
		log.debug("attaching dirty Logs instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logs instance) {
		log.debug("attaching clean Logs instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Logs persistentInstance) {
		log.debug("deleting Logs instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Logs merge(Logs detachedInstance) {
		log.debug("merging Logs instance");
		try {
			Logs result = (Logs) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Logs findById(java.lang.Integer id) {
		log.debug("getting Logs instance with id: " + id);
		try {
			Logs instance = (Logs) sessionFactory.getCurrentSession().get("br.com.jangada.dao.Logs", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Logs instance) {
		log.debug("finding Logs instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("br.com.jangada.dao.Logs")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
