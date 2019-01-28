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
import beans.dto.MenajeDTO;
import beans.model.Elaboraciones;
import beans.model.MateriasPrimas;
import beans.model.Menaje;

@Repository("menajeDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class MenajeDAOImpl extends HibernateDaoSupport implements MenajeDAO {

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);

	}

	@Override
	public Menaje guardar(Menaje menaje) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			session.saveOrUpdate(menaje);
			 
			 
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}
		
		return null;

	}

	@Override
	public List<MenajeDTO> obtenerMenajes() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<MenajeDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT MENAJE_PKL as id, "
		  		+ "NOMBRE as nombre, TIPO_MENAJE_FK as tipoMenaje FROM ELABORACIONES");
		  StringBuffer query = null;
		  sql.addScalar("id",IntegerType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		  sql.addScalar("tipoMenaje",IntegerType.INSTANCE);

		  
		  sql.setResultTransformer(Transformers.aliasToBean(MenajeDTO.class));
	
		    entries =(ArrayList<MenajeDTO>) sql.list() ;
		    if(entries==null) {
		    	entries = new ArrayList<MenajeDTO>();
		    }
	}catch(DataAccessException dae) {
		throw new DataAccessException(dae.getMessage()) {
		};
	
	}
		
		return entries;
	}

	@Override
	public Menaje obtenerMenaje(Integer idMenaje) throws DataAccessException {
		Menaje resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (Menaje) session.get(Menaje.class, idMenaje);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

}
