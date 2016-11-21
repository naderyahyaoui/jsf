package service;

import java.net.URL;
import java.util.List;

import javax.ejb.Remote;

import domain.Materiels;
@Remote
public interface MaterialsRemote {
Boolean addMaterial(Materiels materiels );
	
	Boolean updateMaterial(Materiels materiels);

	Boolean deleteMaterial(Materiels materiels);

	
	Materiels findMaterialById(int idM);

	List<Materiels> findAllMaterials();
	  String cleanUrl(URL url);

}
