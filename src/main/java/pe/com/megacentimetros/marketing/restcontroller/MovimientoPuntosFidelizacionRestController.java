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
import pe.com.megacentimetros.marketing.entity.MovimientoPuntosFidelizacionEntity;
import pe.com.megacentimetros.marketing.service.MovimientoPuntosFidelizacionService;

@RestController
@RequestMapping("/api/movimientopuntosfidelizacion")
public class MovimientoPuntosFidelizacionRestController {

	@Autowired
	private MovimientoPuntosFidelizacionService servicio;

	@GetMapping
	public List<MovimientoPuntosFidelizacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<MovimientoPuntosFidelizacionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public MovimientoPuntosFidelizacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public MovimientoPuntosFidelizacionEntity add(@RequestBody MovimientoPuntosFidelizacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public MovimientoPuntosFidelizacionEntity update(@RequestBody MovimientoPuntosFidelizacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public MovimientoPuntosFidelizacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public MovimientoPuntosFidelizacionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
