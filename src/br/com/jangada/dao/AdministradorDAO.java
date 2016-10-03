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

import br.com.jangada.bd.Administrador;

/**
 * Home object for domain model class Administador.
 * @see br.com.jangada.dao.Administrador
 * @author Hibernate Tools 
 */
public class AdministradorDAO {

	private static final Log log = LogFactory.getLog(AdministradorDAO.class);

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

	public void persist(Administrador transientInstance) {
		log.debug("persisting Administrador instance");
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

	public void attachDirty(Administrador instance) {
		log.debug("attaching dirty Administador instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrador instance) {
		log.debug("attaching clean Administador instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Administrador persistentInstance) {
		log.debug("deleting Administador instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().delete(persistentInstance);
			sessionFactory.getCurrentSession().beginTransaction().commit();
			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrador merge(Administrador detachedInstance) {
		log.debug("merging Administador instance");
		try {
			Administrador result = (Administrador) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Administrador findById(java.lang.Integer id) {
		log.debug("getting Administador instance with id: " + id);
		try {
			Administrador instance = (Administrador) sessionFactory.getCurrentSession()
					.get("br.com.jangada.dao.Administador", id);
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
	
	

	public List findByExample(Administrador instance) {
		log.debug("finding Administador instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("br.com.jangada.dao.Administador")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List listaAdministrador(Administrador instance) {
		log.debug("finding Administador instance by example");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			List results = sessionFactory.getCurrentSession().createCriteria(Administrador.class).list();
			sessionFactory.getCurrentSession().beginTransaction().commit();
			
			//= sessionFactory.getCurrentSession().createCriteria("br.com.jangada.dao.Administador")
			//		.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
}
