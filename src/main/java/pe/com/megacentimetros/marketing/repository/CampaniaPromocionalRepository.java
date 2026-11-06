package pe.com.megacentimetros.marketing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.marketing.entity.CampaniaPromocionalEntity;

public interface CampaniaPromocionalRepository extends JpaRepository<CampaniaPromocionalEntity, Long> {

	@Query("select d from CampaniaPromocionalEntity d where d.estado = true")
	List<CampaniaPromocionalEntity> findAllCustom();
}
