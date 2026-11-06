package pe.com.megacentimetros.marketing.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.marketing.entity.ClienteCampaniaEntity;
import pe.com.megacentimetros.marketing.service.ClienteCampaniaService;

@RestController
@RequestMapping("/api/clientecampania")
public class ClienteCampaniaRestController {

	@Autowired
	private ClienteCampaniaService servicio;

	@GetMapping
	public List<ClienteCampaniaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<ClienteCampaniaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public ClienteCampaniaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public ClienteCampaniaEntity add(@RequestBody ClienteCampaniaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public ClienteCampaniaEntity update(@RequestBody ClienteCampaniaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public ClienteCampaniaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public ClienteCampaniaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
