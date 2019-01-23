package beans.service;



import java.util.List;

import org.hibernate.service.spi.ServiceException;

import beans.dto.ConservacionesDTO;
import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.dto.PlatosDTO;
import beans.dto.TipoPlatoDTO;

public interface PlatosService {

	List<TipoPlatoDTO> obtenerTipoPlato() throws ServiceException;

	List<ElaboracionesDTO> obtenerElaboraciones() throws ServiceException;

	void guardar(PlatosDTO platosDTO) throws ServiceException; 
}
