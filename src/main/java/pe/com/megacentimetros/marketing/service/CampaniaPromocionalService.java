package pe.com.megacentimetros.marketing.service;

import java.util.List;
import pe.com.megacentimetros.marketing.entity.CampaniaPromocionalEntity;

public interface CampaniaPromocionalService {

	List<CampaniaPromocionalEntity> findAll();

	List<CampaniaPromocionalEntity> findAllCustom();

	CampaniaPromocionalEntity findById(Long id);

	CampaniaPromocionalEntity add(CampaniaPromocionalEntity obj);

	CampaniaPromocionalEntity update(CampaniaPromocionalEntity obj, Long id);

	CampaniaPromocionalEntity delete(Long id);

	CampaniaPromocionalEntity enable(Long id);
}
