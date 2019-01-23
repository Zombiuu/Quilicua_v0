package beans.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import beans.model.Elaboraciones;
import beans.model.Platos;

@Repository("platosDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class PlatosDAOImpl extends HibernateDaoSupport implements PlatosDAO {

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);

	}

	@Override
	public Platos guardar(Platos platos) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			session.saveOrUpdate(platos);
			 
			 
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}
		
		return null;

	}

}
