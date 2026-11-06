package pe.com.megacentimetros.marketing.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.marketing.client.PersonaFeignClient;
import pe.com.megacentimetros.marketing.exception.ResourceNotFoundException;
import pe.com.megacentimetros.marketing.entity.ClienteCampaniaEntity;
import pe.com.megacentimetros.marketing.repository.ClienteCampaniaRepository;
import pe.com.megacentimetros.marketing.service.ClienteCampaniaService;

@Service
public class ClienteCampaniaServiceImpl implements ClienteCampaniaService {

	private ClienteCampaniaRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public ClienteCampaniaServiceImpl(ClienteCampaniaRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<ClienteCampaniaEntity> findAll() {
		List<ClienteCampaniaEntity> lista = repositorio.findAll();
		for (ClienteCampaniaEntity clienteCampania : lista) {
			clienteCampania.setCliente(personaFeignClient.getCliente(clienteCampania.getCodcli()));
		}
		return lista;
	}
	@Override
	public List<ClienteCampaniaEntity> findAllCustom() {
		List<ClienteCampaniaEntity> lista = repositorio.findAllCustom();
		for (ClienteCampaniaEntity clienteCampania : lista) {
			clienteCampania.setCliente(personaFeignClient.getCliente(clienteCampania.getCodcli()));
		}
		return lista;
	}
	@Override
	public ClienteCampaniaEntity findById(Long id) {
		ClienteCampaniaEntity clienteCampania = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClienteCampania con id " + id + " no existe"));
		clienteCampania.setCliente(personaFeignClient.getCliente(clienteCampania.getCodcli()));
		return clienteCampania;
	}
	@Override
	public ClienteCampaniaEntity add(ClienteCampaniaEntity obj) {
		obj.setEstado(true);
		if (obj.getFechaAsignacion() == null) {
			obj.setFechaAsignacion(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public ClienteCampaniaEntity update(ClienteCampaniaEntity obj, Long id) {
		ClienteCampaniaEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClienteCampania con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcli, "codigo");
		return repositorio.save(objcli);
	}
	@Override
	public ClienteCampaniaEntity delete(Long id) {
		ClienteCampaniaEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClienteCampania con id " + id + " no existe"));
		objcli.setEstado(false);
		return repositorio.save(objcli);
	}
	@Override
	public ClienteCampaniaEntity enable(Long id) {
		ClienteCampaniaEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClienteCampania con id " + id + " no existe"));
		objcli.setEstado(true);
		return repositorio.save(objcli);
	}
}
