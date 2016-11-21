package ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import domain.CompteCourant;
import service.GestionCompteLocal;

@Path("/comptc")
public class CompteCourantRessouces {
	@Inject
	GestionCompteLocal ejb;
	@POST
	@Consumes("application/json")
	public String addCompte(CompteCourant m){
		if(ejb.addCompte(m))
		return "success";
		return "fail";
		}

	@GET
	@Produces("application/json")
	public List<CompteCourant> FindAllAccounts()
	{return ejb.findAllAccountc();}


}
