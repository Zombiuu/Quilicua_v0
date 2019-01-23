package beans.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.model.RelElaboracionesMateriasPrimas;
import beans.model.RelPlatosElaboraciones;

@Repository("relacionPlatosElaboracionesDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class RelacionPlatosElaboracionesDAOImpl extends HibernateDaoSupport implements RelacionPlatosElaboracionesDAO{
	
	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}

	

	@Override
	public RelPlatosElaboraciones guardar(RelPlatosElaboraciones relPlatosElaboraciones) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.saveOrUpdate(relPlatosElaboraciones);
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}
		return relPlatosElaboraciones;
		
	}

}
