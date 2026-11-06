package pe.com.megacentimetros.marketing.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.marketing.exception.ResourceNotFoundException;
import pe.com.megacentimetros.marketing.entity.CampaniaPromocionalEntity;
import pe.com.megacentimetros.marketing.repository.CampaniaPromocionalRepository;
import pe.com.megacentimetros.marketing.service.CampaniaPromocionalService;

@Service
public class CampaniaPromocionalServiceImpl implements CampaniaPromocionalService {

	private CampaniaPromocionalRepository repositorio;

	public CampaniaPromocionalServiceImpl(CampaniaPromocionalRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CampaniaPromocionalEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CampaniaPromocionalEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CampaniaPromocionalEntity findById(Long id) {
		CampaniaPromocionalEntity campaniaPromocional = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CampaniaPromocional con id " + id + " no existe"));
		return campaniaPromocional;
	}
	@Override
	public CampaniaPromocionalEntity add(CampaniaPromocionalEntity obj) {
		obj.setEstado(true);
		if (obj.getSituacion() == null) {
			obj.setSituacion("PLANIFICADA");
		}
		return repositorio.save(obj);
	}
	@Override
	public CampaniaPromocionalEntity update(CampaniaPromocionalEntity obj, Long id) {
		CampaniaPromocionalEntity objcam = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CampaniaPromocional con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcam, "codigo");
		return repositorio.save(objcam);
	}
	@Override
	public CampaniaPromocionalEntity delete(Long id) {
		CampaniaPromocionalEntity objcam = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CampaniaPromocional con id " + id + " no existe"));
		objcam.setEstado(false);
		return repositorio.save(objcam);
	}
	@Override
	public CampaniaPromocionalEntity enable(Long id) {
		CampaniaPromocionalEntity objcam = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CampaniaPromocional con id " + id + " no existe"));
		objcam.setEstado(true);
		return repositorio.save(objcam);
	}
}
