package br.com.jangada.dao;
// Generated 11/09/2016 22:05:50 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.jangada.bd.Clientes;

/**
 * Home object for domain model class Clientes.
 * @see br.com.jangada.dao.Clientes
 * @author Hibernate Tools 
 */
public class ClientesDAO {

	private static final Log log = LogFactory.getLog(ClientesDAO.class);

	private SessionFactory sessionFactory = getSessionFactory();

		protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Clientes transientInstance) {
		log.debug("persisting Clientes instance");
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

	public void attachDirty(Clientes instance) {
		log.debug("attaching dirty Clientes instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			sessionFactory.getCurrentSession().beginTransaction().commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clientes instance) {
		log.debug("attaching clean Clientes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Clientes persistentInstance) {
		log.debug("deleting Clientes instance");
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

	public Clientes merge(Clientes detachedInstance) {
		log.debug("merging Clientes instance");
		try {
			Clientes result = (Clientes) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	

	public Clientes findById(java.lang.Integer id) {
		log.debug("getting Clientes instance with id: " + id);
		try {
			Clientes instance = (Clientes) sessionFactory.getCurrentSession().get("br.com.jangada.dao.Clientes", id);
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

	public List<Clientes> findByExample(String pesqField,Object pesqValue) {
		log.debug("finding Clientes instance by example");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Clientes.class);	
			criteria.add(Restrictions.eq(pesqField, pesqValue));
			List<Clientes> results = criteria.list();
			
			sessionFactory.getCurrentSession().beginTransaction().commit();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Clientes> findByConteudo(String pesqField, String pesqValue, int filtroLinha,
			int filtroConteudo, int filtroExclusivo) {
		log.debug("finding Noticias instance by example");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Clientes.class);
			
			if (filtroExclusivo == 0){
				switch (filtroConteudo) {
				case 2:
					criteria.add(Restrictions.ilike(pesqField, pesqValue, MatchMode.ANYWHERE));
					break;
				case 3:
					criteria.add(Restrictions.ilike(pesqField, pesqValue, MatchMode.START));
					break;	
				case 4:
					criteria.add(Restrictions.ilike(pesqField, pesqValue, MatchMode.END));
					break;				
				}
			}	
			else
				criteria.add(Restrictions.isNull(pesqField));	
			if (filtroLinha == 2)
				criteria.setMaxResults(1);	
			else
				if (filtroLinha == 3)
					criteria.setMaxResults(5);		
			
			List<Clientes> results = criteria.list();
			
			sessionFactory.getCurrentSession().beginTransaction().commit();
			
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List listarClientes() {
		log.debug("finding Administador instance by example");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Clientes.class);			
			List results = criteria.list();
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
