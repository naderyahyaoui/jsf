package ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import service.GestionCompteLocal;
import domain.CompteBusiness;
import domain.CompteEpargne;

@Path("compte")
public class CompteEpargneRessourses {
	@Inject
	GestionCompteLocal ejb;
	@POST
	@Consumes("application/json")
	public String addCompte(CompteEpargne m){
		if(ejb.addCompte(m))
		return "success";
		return "fail";
		}

	@GET
	@Produces("application/json")
	public List<CompteEpargne> FindAllAccounts()
	{return ejb.findAllAccounte();}


}
