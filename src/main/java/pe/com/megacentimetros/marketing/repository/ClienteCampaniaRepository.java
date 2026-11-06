package pe.com.megacentimetros.marketing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.marketing.entity.ClienteCampaniaEntity;

public interface ClienteCampaniaRepository extends JpaRepository<ClienteCampaniaEntity, Long> {

	@Query("select d from ClienteCampaniaEntity d where d.estado = true")
	List<ClienteCampaniaEntity> findAllCustom();
}
