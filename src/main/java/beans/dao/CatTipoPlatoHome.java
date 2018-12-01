package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.CatTipoPlato;

/**
 * Home object for domain model class CatTipoPlato.
 * @see beans.model.CatTipoPlato
 * @author Hibernate Tools
 */
public class CatTipoPlatoHome {

	private static final Log log = LogFactory.getLog(CatTipoPlatoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CatTipoPlato transientInstance) {
		log.debug("persisting CatTipoPlato instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CatTipoPlato instance) {
		log.debug("attaching dirty CatTipoPlato instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatTipoPlato instance) {
		log.debug("attaching clean CatTipoPlato instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CatTipoPlato persistentInstance) {
		log.debug("deleting CatTipoPlato instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatTipoPlato merge(CatTipoPlato detachedInstance) {
		log.debug("merging CatTipoPlato instance");
		try {
			CatTipoPlato result = (CatTipoPlato) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CatTipoPlato findById(java.lang.Integer id) {
		log.debug("getting CatTipoPlato instance with id: " + id);
		try {
			CatTipoPlato instance = (CatTipoPlato) sessionFactory.getCurrentSession().get("beans.model.CatTipoPlato",
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

	public List findByExample(CatTipoPlato instance) {
		log.debug("finding CatTipoPlato instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.CatTipoPlato")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
