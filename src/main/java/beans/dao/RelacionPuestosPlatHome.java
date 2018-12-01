package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.RelacionPuestosPlat;

/**
 * Home object for domain model class RelacionPuestosPlat.
 * @see beans.model.RelacionPuestosPlat
 * @author Hibernate Tools
 */
public class RelacionPuestosPlatHome {

	private static final Log log = LogFactory.getLog(RelacionPuestosPlatHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RelacionPuestosPlat transientInstance) {
		log.debug("persisting RelacionPuestosPlat instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionPuestosPlat instance) {
		log.debug("attaching dirty RelacionPuestosPlat instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionPuestosPlat instance) {
		log.debug("attaching clean RelacionPuestosPlat instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RelacionPuestosPlat persistentInstance) {
		log.debug("deleting RelacionPuestosPlat instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionPuestosPlat merge(RelacionPuestosPlat detachedInstance) {
		log.debug("merging RelacionPuestosPlat instance");
		try {
			RelacionPuestosPlat result = (RelacionPuestosPlat) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RelacionPuestosPlat findById(java.lang.Integer id) {
		log.debug("getting RelacionPuestosPlat instance with id: " + id);
		try {
			RelacionPuestosPlat instance = (RelacionPuestosPlat) sessionFactory.getCurrentSession()
					.get("beans.model.RelacionPuestosPlat", id);
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

	public List findByExample(RelacionPuestosPlat instance) {
		log.debug("finding RelacionPuestosPlat instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.RelacionPuestosPlat")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
