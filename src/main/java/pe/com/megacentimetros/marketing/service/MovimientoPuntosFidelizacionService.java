package pe.com.megacentimetros.marketing.service;

import java.util.List;
import pe.com.megacentimetros.marketing.entity.MovimientoPuntosFidelizacionEntity;

public interface MovimientoPuntosFidelizacionService {

	List<MovimientoPuntosFidelizacionEntity> findAll();

	List<MovimientoPuntosFidelizacionEntity> findAllCustom();

	MovimientoPuntosFidelizacionEntity findById(Long id);

	MovimientoPuntosFidelizacionEntity add(MovimientoPuntosFidelizacionEntity obj);

	MovimientoPuntosFidelizacionEntity update(MovimientoPuntosFidelizacionEntity obj, Long id);

	MovimientoPuntosFidelizacionEntity delete(Long id);

	MovimientoPuntosFidelizacionEntity enable(Long id);
}
