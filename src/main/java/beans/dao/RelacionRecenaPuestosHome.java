package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.RelacionRecenaPuestos;

/**
 * Home object for domain model class RelacionRecenaPuestos.
 * @see beans.model.RelacionRecenaPuestos
 * @author Hibernate Tools
 */
public class RelacionRecenaPuestosHome {

	private static final Log log = LogFactory.getLog(RelacionRecenaPuestosHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RelacionRecenaPuestos transientInstance) {
		log.debug("persisting RelacionRecenaPuestos instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionRecenaPuestos instance) {
		log.debug("attaching dirty RelacionRecenaPuestos instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionRecenaPuestos instance) {
		log.debug("attaching clean RelacionRecenaPuestos instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RelacionRecenaPuestos persistentInstance) {
		log.debug("deleting RelacionRecenaPuestos instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionRecenaPuestos merge(RelacionRecenaPuestos detachedInstance) {
		log.debug("merging RelacionRecenaPuestos instance");
		try {
			RelacionRecenaPuestos result = (RelacionRecenaPuestos) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RelacionRecenaPuestos findById(java.lang.Integer id) {
		log.debug("getting RelacionRecenaPuestos instance with id: " + id);
		try {
			RelacionRecenaPuestos instance = (RelacionRecenaPuestos) sessionFactory.getCurrentSession()
					.get("beans.model.RelacionRecenaPuestos", id);
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

	public List findByExample(RelacionRecenaPuestos instance) {
		log.debug("finding RelacionRecenaPuestos instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.RelacionRecenaPuestos")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
