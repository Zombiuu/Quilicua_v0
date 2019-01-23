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

@Repository("relacionElaboracionMatPrimasDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class RelacionElaboracionMatPrimasDAOImpl extends HibernateDaoSupport implements RelacionElaboracionMatPrimasDAO {
	
	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
		
	}

	@Override
	public void guardar(RelElaboracionesMateriasPrimas rel) throws DataAccessException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.saveOrUpdate(rel);
		} catch (DataAccessException dae) {
			throw new DataAccessException(dae.getMessage()) {
			};
		}

		
	}

}
