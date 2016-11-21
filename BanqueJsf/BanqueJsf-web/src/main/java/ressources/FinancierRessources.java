package ressources;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;




import javax.ws.rs.QueryParam;

import domain.Materiels;
import service.MaterialsLocal;

@Path("finance")
public class FinancierRessources {
@Inject
MaterialsLocal myEjb;

@GET
@Produces("application/json")
public List<Materiels> findAllFinancial() {
	return myEjb.findAllMaterials();
	
}

@DELETE
@Consumes("application/json")
public void supp(@QueryParam(value="id")int id)
{
	myEjb.deleteMaterial(myEjb.findMaterialById(id));}

@POST
@Consumes("application/json")
public void addMaterial(Materiels materiels){
	myEjb.addMaterial(materiels);
}
}
