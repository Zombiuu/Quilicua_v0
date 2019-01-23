package beans.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.model.Elaboraciones;
import beans.model.MateriasPrimas;

@Repository("elaboracionesDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class ElaboracionesDAOImpl extends HibernateDaoSupport implements ElaboracionesDAO {

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);

	}

	@Override
	public Elaboraciones guardar(Elaboraciones elaboracion) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			session.saveOrUpdate(elaboracion);
			 
			 
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}
		
		return null;

	}

	@Override
	public List<ElaboracionesDTO> obtenerElaboraciones() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<ElaboracionesDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT ELABORACIONES_PK as id, "
		  		+ "NOMBRE as nombre FROM ELABORACIONES");
		  StringBuffer query = null;
		  sql.addScalar("id",IntegerType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		
		  
		  sql.setResultTransformer(Transformers.aliasToBean(ElaboracionesDTO.class));
	
		    entries =(ArrayList<ElaboracionesDTO>) sql.list() ;
		    if(entries==null) {
		    	entries = new ArrayList<ElaboracionesDTO>();
		    }
	}catch(DataAccessException dae) {
		throw new DataAccessException(dae.getMessage()) {
		};
	
	}
		
		return entries;
	}

	@Override
	public Elaboraciones obtenerElaboracion(Integer idELaboracion) throws DataAccessException {
		Elaboraciones resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (Elaboraciones) session.get(Elaboraciones.class, idELaboracion);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

}
