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

import beans.dto.ConservacionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.dto.TipoPlatoDTO;
import beans.model.CatConservaciones;
import beans.model.CatTipoPlato;
import beans.model.MateriasPrimas;

@Repository("tipoPlatoDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class TipoPlatoDAOImpl extends HibernateDaoSupport implements TipoPlatoDAO {

	

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}

	

	@Override
	public List<TipoPlatoDTO> obtenerListaTipoPlato() throws DataAccessException {
		 SQLQuery sql = null;
		 ArrayList<TipoPlatoDTO> entries= null;
			try {
				  sql = getSessionFactory().getCurrentSession().createSQLQuery("SELECT CAT_TIPO_PLATO_PK as id,"
				  		+ " NOMBRE as nombre FROM quilicuabd.CAT_TIPO_PLATO");
				  StringBuffer query = null;
				  sql.addScalar("id",IntegerType.INSTANCE);
				  sql.addScalar("nombre",StringType.INSTANCE);
				
				  
				  sql.setResultTransformer(Transformers.aliasToBean(TipoPlatoDTO.class));
			
				    entries =(ArrayList<TipoPlatoDTO>) sql.list() ;
				    if(entries==null) {
				    	entries = new ArrayList<TipoPlatoDTO>();
				    }
			}catch(DataAccessException dae) {
				throw new DataAccessException(dae.getMessage()) {
				};
			
			}
				
				return entries;
	}

	@Override
	public CatTipoPlato obtenerTipoPlato(Integer tipoPlato) throws DataAccessException {
		CatTipoPlato resultado = null;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			 resultado = (CatTipoPlato) session.get(CatTipoPlato.class, tipoPlato);
			

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

	

	
}
