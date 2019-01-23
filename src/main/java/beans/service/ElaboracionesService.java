package beans.service;



import java.util.List;

import org.hibernate.service.spi.ServiceException;

import beans.dto.ConservacionesDTO;
import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;

public interface ElaboracionesService {
	List<MateriasPrimasDTO> obtenerMatPrimas() throws ServiceException;

	List<ConservacionesDTO> obtenerConservaciones() throws ServiceException;

	void guardar(ElaboracionesDTO elaboracionDTO) throws ServiceException;
}
