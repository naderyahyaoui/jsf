package service;

import java.net.URL;
import java.util.List;

import javax.ejb.Local;

import domain.Materiels;
@Local
public interface MaterialsLocal {
Boolean addMaterial(Materiels materiels );
	
	Boolean updateMaterial(Materiels materiels);

	Boolean deleteMaterial(Materiels materiels);

	
	Materiels findMaterialById(int idM);

	List<Materiels> findAllMaterials();
	  String cleanUrl(URL url);


}
