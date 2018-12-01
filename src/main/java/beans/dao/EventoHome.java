package beans.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dto.EventoDTO;
import beans.model.Evento;

/**
 * Home object for domain model class Evento.
 * @see beans.model.Evento
 * @author Hibernate Tools
 */
@Repository("eventoDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class EventoHome extends HibernateDaoSupport implements EventoDAO{

	private static final Log log = LogFactory.getLog(EventoHome.class);

	
	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
	}

	public void persist(Evento transientInstance) {
		log.debug("persisting Evento instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Evento instance) {
		log.debug("attaching dirty Evento instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Evento instance) {
		log.debug("attaching clean Evento instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Evento persistentInstance) {
		log.debug("deleting Evento instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Evento merge(Evento detachedInstance) {
		log.debug("merging Evento instance");
		try {
			Evento result = (Evento) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Evento findById(java.lang.Integer id) {
		log.debug("getting Evento instance with id: " + id);
		try {
			Evento instance = (Evento) getSessionFactory().getCurrentSession().get("beans.model.Evento", id);
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

	public List findByExample(Evento instance) {
		log.debug("finding Evento instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("beans.model.Evento")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public ArrayList<EventoDTO> getTotalResult() throws DataAccessException{
		 SQLQuery sql = null;
		 ArrayList<EventoDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT evento.FECHA_ALTA as fechaAlta, evento.NOMBRE as nombre, evento.COMENSALES as comensales, evento.ENCARGADO as encargado FROM evento");
		  sql.addScalar("fechaAlta",DateType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		  sql.addScalar("comensales",IntegerType.INSTANCE);
		  sql.addScalar("encargado",StringType.INSTANCE);
		  
		  sql.setResultTransformer(Transformers.aliasToBean(EventoDTO.class));
		 
		    entries = (ArrayList<EventoDTO>) sql.list();
		    if(entries==null) {
		    	entries = new ArrayList<EventoDTO>();
		    }
	}catch(DataAccessException dae) {
		throw new DataAccessException(dae.getMessage()) {
		};
	
	}
		
		return entries;
		
	}

	
}
