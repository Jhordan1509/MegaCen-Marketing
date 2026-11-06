package pe.com.megacentimetros.marketing.service;

import java.util.List;
import pe.com.megacentimetros.marketing.entity.ClienteCampaniaEntity;

public interface ClienteCampaniaService {

	List<ClienteCampaniaEntity> findAll();

	List<ClienteCampaniaEntity> findAllCustom();

	ClienteCampaniaEntity findById(Long id);

	ClienteCampaniaEntity add(ClienteCampaniaEntity obj);

	ClienteCampaniaEntity update(ClienteCampaniaEntity obj, Long id);

	ClienteCampaniaEntity delete(Long id);

	ClienteCampaniaEntity enable(Long id);
}
