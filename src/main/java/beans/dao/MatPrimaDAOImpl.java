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


import beans.dto.MateriasPrimasDTO;

import beans.model.MateriasPrimas;

@Repository("matPrimaDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class MatPrimaDAOImpl extends HibernateDaoSupport implements MatPrimaDAO {

	

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}

	@Override
	public void guardar(MateriasPrimas materiasPrimas) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.saveOrUpdate(materiasPrimas);
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}

	}

	@Override
	public List<MateriasPrimasDTO> obtenerMatPrimas() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<MateriasPrimasDTO> entries= null;
	try {
		  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT MATERIAS_PRIMAS_PK as idMatPrima, "
		  		+ "NOMBRE as nombre FROM MATERIAS_PRIMAS");
		  StringBuffer query = null;
		  sql.addScalar("idMatPrima",IntegerType.INSTANCE);
		  sql.addScalar("nombre",StringType.INSTANCE);
		
		  
		  sql.setResultTransformer(Transformers.aliasToBean(MateriasPrimasDTO.class));
	
		    entries =(ArrayList<MateriasPrimasDTO>) sql.list() ;
		    if(entries==null) {
		    	entries = new ArrayList<MateriasPrimasDTO>();
		    }
	}catch(DataAccessException dae) {
		throw new DataAccessException(dae.getMessage()) {
		};
	
	}
		
		return entries;
		
	}

	@Override
	public MateriasPrimas obtenerMateriaPrima(Integer idMatPrima) throws DataAccessException {
		MateriasPrimas resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (MateriasPrimas) session.get(MateriasPrimas.class, idMatPrima);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

	
}
