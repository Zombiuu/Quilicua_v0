package beans.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

}
