package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.Ingredientes;

/**
 * Home object for domain model class Ingredientes.
 * @see beans.model.Ingredientes
 * @author Hibernate Tools
 */
public class IngredientesHome {

	private static final Log log = LogFactory.getLog(IngredientesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Ingredientes transientInstance) {
		log.debug("persisting Ingredientes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ingredientes instance) {
		log.debug("attaching dirty Ingredientes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ingredientes instance) {
		log.debug("attaching clean Ingredientes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ingredientes persistentInstance) {
		log.debug("deleting Ingredientes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ingredientes merge(Ingredientes detachedInstance) {
		log.debug("merging Ingredientes instance");
		try {
			Ingredientes result = (Ingredientes) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ingredientes findById(java.lang.Integer id) {
		log.debug("getting Ingredientes instance with id: " + id);
		try {
			Ingredientes instance = (Ingredientes) sessionFactory.getCurrentSession().get("beans.model.Ingredientes",
					id);
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

	public List findByExample(Ingredientes instance) {
		log.debug("finding Ingredientes instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.Ingredientes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
