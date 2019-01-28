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

import beans.dto.TipoMenajeDTO;
import beans.model.CatTipoMenaje;

@Repository("tipoMenajeDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class TipoMenajeDAOImpl extends HibernateDaoSupport implements TipoMenajeDAO{
	

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}
	
	@Override
	public List<TipoMenajeDTO> obtenerTiposMenaje() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<TipoMenajeDTO> entries= null;
			try {
				  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT CAT_TIPO_MENAJE_PK as idTipoMenaje,"
				  		+ " NOMBRE as nombre FROM quilicuabd.CAT_TIPO_MENAJE");
				  StringBuffer query = null;
				  sql.addScalar("idTipoMenaje",IntegerType.INSTANCE);
				  sql.addScalar("nombre",StringType.INSTANCE);
				
				  
				  sql.setResultTransformer(Transformers.aliasToBean(TipoMenajeDTO.class));
			
				    entries =(ArrayList<TipoMenajeDTO>) sql.list() ;
				    if(entries==null) {
				    	entries = new ArrayList<TipoMenajeDTO>();
				    }
			}catch(DataAccessException dae) {
				throw new DataAccessException(dae.getMessage()) {
				};
			
			}
				
				return entries;
	}

	@Override
	public CatTipoMenaje obtenerTipoMenaje(Integer valueTipoMenaje) throws DataAccessException {
		CatTipoMenaje resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (CatTipoMenaje) session.get(CatTipoMenaje.class, valueTipoMenaje);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}
	
	


}
