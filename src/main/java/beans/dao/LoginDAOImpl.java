package beans.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.model.Login;
import beans.model.Usuarios;

@Repository("loginDAO")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {

	@Autowired
	public void initSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public Boolean validarUsernamePassword(Usuarios usuarios) throws DataAccessException {
		boolean resultado = false;

		try {
			Session session = this.getSessionFactory().getCurrentSession();
			
			// Login resultado = (Login) session.get(Login.class, login.getUid());
			Criteria cr = session.createCriteria(Usuarios.class);
			cr.add(Restrictions.eq("nombre", usuarios.getNombre()));
			cr.add(Restrictions.eq("password", usuarios.getPassword()));
			List resultadoBBDD = cr.list();
			if (resultadoBBDD.size() == 1) {
				resultado = true;
				
			} else {
				resultado = false;
			}

		} catch (DataAccessException dae) {
			dae.getMessage();
		}

		return resultado;
	}

}
