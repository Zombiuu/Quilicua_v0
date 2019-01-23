package beans.dao;

import org.springframework.dao.DataAccessException;


import beans.model.Elaboraciones;
import beans.model.RelPlatosElaboraciones;

public interface RelacionPlatosElaboracionesDAO {
	
	RelPlatosElaboraciones guardar(RelPlatosElaboraciones relPlatosElaboraciones) throws DataAccessException;

}
