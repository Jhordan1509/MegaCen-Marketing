package pe.com.megacentimetros.marketing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.marketing.entity.ProgramaFidelizacionEntity;

public interface ProgramaFidelizacionRepository extends JpaRepository<ProgramaFidelizacionEntity, Long> {

	@Query("select d from ProgramaFidelizacionEntity d where d.estado = true")
	List<ProgramaFidelizacionEntity> findAllCustom();
}
