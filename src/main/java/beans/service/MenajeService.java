package beans.service;



import java.util.List;

import org.hibernate.service.spi.ServiceException;


import beans.dto.MenajeDTO;
import beans.dto.TipoMenajeDTO;

public interface MenajeService {

	List<TipoMenajeDTO> obtenerTiposMenaje() throws ServiceException;

	void guardar(MenajeDTO menajeDTO) throws ServiceException;
}
