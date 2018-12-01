package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.RelacionBanquetePlat;

/**
 * Home object for domain model class RelacionBanquetePlat.
 * @see beans.model.RelacionBanquetePlat
 * @author Hibernate Tools
 */
public class RelacionBanquetePlatHome {

	private static final Log log = LogFactory.getLog(RelacionBanquetePlatHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RelacionBanquetePlat transientInstance) {
		log.debug("persisting RelacionBanquetePlat instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionBanquetePlat instance) {
		log.debug("attaching dirty RelacionBanquetePlat instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionBanquetePlat instance) {
		log.debug("attaching clean RelacionBanquetePlat instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RelacionBanquetePlat persistentInstance) {
		log.debug("deleting RelacionBanquetePlat instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionBanquetePlat merge(RelacionBanquetePlat detachedInstance) {
		log.debug("merging RelacionBanquetePlat instance");
		try {
			RelacionBanquetePlat result = (RelacionBanquetePlat) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RelacionBanquetePlat findById(java.lang.Integer id) {
		log.debug("getting RelacionBanquetePlat instance with id: " + id);
		try {
			RelacionBanquetePlat instance = (RelacionBanquetePlat) sessionFactory.getCurrentSession()
					.get("beans.model.RelacionBanquetePlat", id);
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

	public List findByExample(RelacionBanquetePlat instance) {
		log.debug("finding RelacionBanquetePlat instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.RelacionBanquetePlat")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
