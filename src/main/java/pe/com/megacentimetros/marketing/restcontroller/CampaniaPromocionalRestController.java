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
import pe.com.megacentimetros.marketing.entity.CampaniaPromocionalEntity;
import pe.com.megacentimetros.marketing.service.CampaniaPromocionalService;

@RestController
@RequestMapping("/api/campaniapromocional")
public class CampaniaPromocionalRestController {

	@Autowired
	private CampaniaPromocionalService servicio;

	@GetMapping
	public List<CampaniaPromocionalEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CampaniaPromocionalEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CampaniaPromocionalEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CampaniaPromocionalEntity add(@RequestBody CampaniaPromocionalEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CampaniaPromocionalEntity update(@RequestBody CampaniaPromocionalEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CampaniaPromocionalEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CampaniaPromocionalEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
