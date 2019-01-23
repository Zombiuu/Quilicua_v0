package beans.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dto.ConservacionesDTO;
import beans.model.CatConservaciones;
import beans.model.Usuarios;

@Repository("conservacionesDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class ConservacionesDAOImpl extends HibernateDaoSupport implements ConservacionesDAO{
	

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}
	
	@Override
	public List<ConservacionesDTO> obtenerConservaciones() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<ConservacionesDTO> entries= null;
			try {
				  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT CAT_CONSERVACIONES_PK as idConservacion,"
				  		+ " NOMBRE as nombre FROM quilicuabd.CAT_CONSERVACIONES");
				  StringBuffer query = null;
				  sql.addScalar("idConservacion",IntegerType.INSTANCE);
				  sql.addScalar("nombre",StringType.INSTANCE);
				
				  
				  sql.setResultTransformer(Transformers.aliasToBean(ConservacionesDTO.class));
			
				    entries =(ArrayList<ConservacionesDTO>) sql.list() ;
				    if(entries==null) {
				    	entries = new ArrayList<ConservacionesDTO>();
				    }
			}catch(DataAccessException dae) {
				throw new DataAccessException(dae.getMessage()) {
				};
			
			}
				
				return entries;
	}

	@Override
	public CatConservaciones obtenerConservacion(Integer valueConservacion) throws DataAccessException {
		CatConservaciones resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (CatConservaciones) session.get(CatConservaciones.class, valueConservacion);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}
	
	


}
