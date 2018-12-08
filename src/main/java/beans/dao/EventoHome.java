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

	
	
	public ArrayList<EventoDTO> getTotalResult() throws DataAccessException{
		 SQLQuery sql = null;
		 ArrayList<EventoDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT E.FECHA as fechaAlta, E.NOMBRE as nombre, E.RESPONSABLE as encargado, E.INV_TOTAL as comensales, F.NOMBRE as nombreFinca  FROM EVENTO E LEFT JOIN FINCAS  F ON E.FINCA = F.FINCAS_PK");
		  StringBuffer query = null;
		  sql.addScalar("fechaAlta",DateType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		  sql.addScalar("comensales",IntegerType.INSTANCE);
		  sql.addScalar("encargado",StringType.INSTANCE);
		  sql.addScalar("nombreFinca",StringType.INSTANCE);
		  
		  
		  sql.setResultTransformer(Transformers.aliasToBean(EventoDTO.class));
		 
		    entries =(ArrayList<EventoDTO>) sql.list() ;
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
