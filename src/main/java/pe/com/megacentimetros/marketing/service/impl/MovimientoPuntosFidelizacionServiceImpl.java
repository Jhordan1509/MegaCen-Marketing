package pe.com.megacentimetros.marketing.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.marketing.exception.ResourceNotFoundException;
import pe.com.megacentimetros.marketing.entity.MovimientoPuntosFidelizacionEntity;
import pe.com.megacentimetros.marketing.repository.MovimientoPuntosFidelizacionRepository;
import pe.com.megacentimetros.marketing.service.MovimientoPuntosFidelizacionService;

@Service
public class MovimientoPuntosFidelizacionServiceImpl implements MovimientoPuntosFidelizacionService {

	private MovimientoPuntosFidelizacionRepository repositorio;

	public MovimientoPuntosFidelizacionServiceImpl(MovimientoPuntosFidelizacionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<MovimientoPuntosFidelizacionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<MovimientoPuntosFidelizacionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public MovimientoPuntosFidelizacionEntity findById(Long id) {
		MovimientoPuntosFidelizacionEntity movimientoPuntosFidelizacion = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoPuntosFidelizacion con id " + id + " no existe"));
		return movimientoPuntosFidelizacion;
	}
	@Override
	public MovimientoPuntosFidelizacionEntity add(MovimientoPuntosFidelizacionEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public MovimientoPuntosFidelizacionEntity update(MovimientoPuntosFidelizacionEntity obj, Long id) {
		MovimientoPuntosFidelizacionEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoPuntosFidelizacion con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objmov, "codigo");
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoPuntosFidelizacionEntity delete(Long id) {
		MovimientoPuntosFidelizacionEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoPuntosFidelizacion con id " + id + " no existe"));
		objmov.setEstado(false);
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoPuntosFidelizacionEntity enable(Long id) {
		MovimientoPuntosFidelizacionEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoPuntosFidelizacion con id " + id + " no existe"));
		objmov.setEstado(true);
		return repositorio.save(objmov);
	}
}
