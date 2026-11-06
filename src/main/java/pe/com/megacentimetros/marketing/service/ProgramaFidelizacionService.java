package pe.com.megacentimetros.marketing.service;

import java.util.List;
import pe.com.megacentimetros.marketing.entity.ProgramaFidelizacionEntity;

public interface ProgramaFidelizacionService {

	List<ProgramaFidelizacionEntity> findAll();

	List<ProgramaFidelizacionEntity> findAllCustom();

	ProgramaFidelizacionEntity findById(Long id);

	ProgramaFidelizacionEntity add(ProgramaFidelizacionEntity obj);

	ProgramaFidelizacionEntity update(ProgramaFidelizacionEntity obj, Long id);

	ProgramaFidelizacionEntity delete(Long id);

	ProgramaFidelizacionEntity enable(Long id);
}
