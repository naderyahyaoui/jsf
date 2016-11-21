package ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import service.GestionCompteLocal;

import domain.CompteMineur;
@Path("/comptm")
public class CompteMineurRessources {
	@Inject
	GestionCompteLocal ejb;
	@POST
	@Consumes("application/json")
	public String addCompte(CompteMineur m){
		if(ejb.addCompte(m))
		return "success";
		return "fail";
		}

	@GET
	@Produces("application/json")
	public List<CompteMineur> FindAllAccounts()
	{return ejb.findAllAccountm();}


}
