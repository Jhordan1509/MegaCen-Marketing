package pe.com.megacentimetros.marketing.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.marketing.client.PersonaFeignClient;
import pe.com.megacentimetros.marketing.exception.ResourceNotFoundException;
import pe.com.megacentimetros.marketing.entity.ProgramaFidelizacionEntity;
import pe.com.megacentimetros.marketing.repository.ProgramaFidelizacionRepository;
import pe.com.megacentimetros.marketing.service.ProgramaFidelizacionService;

@Service
public class ProgramaFidelizacionServiceImpl implements ProgramaFidelizacionService {

	private ProgramaFidelizacionRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public ProgramaFidelizacionServiceImpl(ProgramaFidelizacionRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<ProgramaFidelizacionEntity> findAll() {
		List<ProgramaFidelizacionEntity> lista = repositorio.findAll();
		for (ProgramaFidelizacionEntity programaFidelizacion : lista) {
			programaFidelizacion.setCliente(personaFeignClient.getCliente(programaFidelizacion.getCodcli()));
		}
		return lista;
	}
	@Override
	public List<ProgramaFidelizacionEntity> findAllCustom() {
		List<ProgramaFidelizacionEntity> lista = repositorio.findAllCustom();
		for (ProgramaFidelizacionEntity programaFidelizacion : lista) {
			programaFidelizacion.setCliente(personaFeignClient.getCliente(programaFidelizacion.getCodcli()));
		}
		return lista;
	}
	@Override
	public ProgramaFidelizacionEntity findById(Long id) {
		ProgramaFidelizacionEntity programaFidelizacion = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaFidelizacion con id " + id + " no existe"));
		programaFidelizacion.setCliente(personaFeignClient.getCliente(programaFidelizacion.getCodcli()));
		return programaFidelizacion;
	}
	@Override
	public ProgramaFidelizacionEntity add(ProgramaFidelizacionEntity obj) {
		obj.setEstado(true);
		if (obj.getPuntosAcumulados() == null) {
			obj.setPuntosAcumulados(0);
		}
		if (obj.getNivel() == null) {
			obj.setNivel("BRONCE");
		}
		return repositorio.save(obj);
	}
	@Override
	public ProgramaFidelizacionEntity update(ProgramaFidelizacionEntity obj, Long id) {
		ProgramaFidelizacionEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaFidelizacion con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objpro, "codigo");
		return repositorio.save(objpro);
	}
	@Override
	public ProgramaFidelizacionEntity delete(Long id) {
		ProgramaFidelizacionEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaFidelizacion con id " + id + " no existe"));
		objpro.setEstado(false);
		return repositorio.save(objpro);
	}
	@Override
	public ProgramaFidelizacionEntity enable(Long id) {
		ProgramaFidelizacionEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaFidelizacion con id " + id + " no existe"));
		objpro.setEstado(true);
		return repositorio.save(objpro);
	}
}
