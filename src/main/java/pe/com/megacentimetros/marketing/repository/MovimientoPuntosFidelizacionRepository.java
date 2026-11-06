package pe.com.megacentimetros.marketing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.marketing.entity.MovimientoPuntosFidelizacionEntity;

public interface MovimientoPuntosFidelizacionRepository extends JpaRepository<MovimientoPuntosFidelizacionEntity, Long> {

	@Query("select d from MovimientoPuntosFidelizacionEntity d where d.estado = true")
	List<MovimientoPuntosFidelizacionEntity> findAllCustom();
}
