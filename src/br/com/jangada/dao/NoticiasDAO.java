package br.com.jangada.dao;
// Generated 11/09/2016 22:05:50 by Hibernate Tools 5.1.0.Alpha1

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.jsp.el.ExpressionEvaluator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Where;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.sun.javafx.fxml.expression.Expression;
import com.sun.javafx.fxml.expression.ExpressionValue;

import br.com.jangada.bd.Noticias;

/**
 * Home object for domain model class Noticias.
 * @see br.com.jangada.dao.Noticias
 * @author Hibernate Tools 
 */
public class NoticiasDAO {

	private static final Log log = LogFactory.getLog(NoticiasDAO.class);

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

	public void persist(Noticias transientInstance) {
		log.debug("persisting Noticias instance");
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

	public void attachDirty(Noticias instance) {
		log.debug("attaching dirty Noticias instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Noticias instance) {
		log.debug("attaching clean Noticias instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Noticias persistentInstance) {
		log.debug("deleting Noticias instance");
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

	public Noticias merge(Noticias detachedInstance) {
		log.debug("merging Noticias instance");
		try {
			Noticias result = (Noticias) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Noticias findById(java.lang.Integer id) {
		log.debug("getting Noticias instance with id: " + id);
		try {
			Noticias instance = (Noticias) sessionFactory.getCurrentSession().get("br.com.jangada.dao.Noticias", id);
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

	public List<Noticias> findByExample(String pesqField,Object pesqValue) {
		log.debug("finding Noticias instance by example");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Noticias.class).add(Restrictions.eq(pesqField, pesqValue));	
			
			List<Noticias> results = criteria.list();
			
			sessionFactory.getCurrentSession().beginTransaction().commit();
			
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Noticias> listaNoticias(Noticias instance){
		log.debug("finding Administador instance by example");
		try {
			
			List<Noticias> results = new ArrayList<Noticias>();
			
			sessionFactory.getCurrentSession().beginTransaction();
			results = sessionFactory.getCurrentSession().createCriteria(instance.getClass()).list();
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
