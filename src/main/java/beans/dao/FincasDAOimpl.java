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

import beans.dto.FincasDTO;
import beans.dto.MateriasPrimasDTO;
import beans.model.Fincas;
import beans.model.MateriasPrimas;

@Repository("fincasDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class FincasDAOimpl extends HibernateDaoSupport implements FincasDAO {

	

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}

	@Override
	public void guardar(Fincas fincas) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.saveOrUpdate(fincas);
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}

	}

	@Override
	public List<FincasDTO> obtenerFincas() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<FincasDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery(
				  " SELECT FINCAS_PK as idFincas, " +
		  		  " NOMBRE as nombre, " +
				  " DIRECCION as direccion " +
		  		  " FROM MATERIAS_PRIMA");
		  StringBuffer query = null;
		  sql.addScalar("idFincas",IntegerType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		  sql.addScalar("direccion",StringType.INSTANCE);
		
		  
		  sql.setResultTransformer(Transformers.aliasToBean(FincasDTO.class));
	
		    entries =(ArrayList<FincasDTO>) sql.list() ;
		    if(entries==null) {
		    	entries = new ArrayList<FincasDTO>();
		    }
	}catch(DataAccessException dae) {
		throw new DataAccessException(dae.getMessage()) {
		};
	
	}
		
		return entries;
		
	}

	@Override
	public Fincas obtenerFinca(Integer idFinca) throws DataAccessException {
		Fincas resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (Fincas) session.get(Fincas.class, idFinca);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

	
}
