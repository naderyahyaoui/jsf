package ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


import javax.ws.rs.Produces;

import domain.CompteBusiness;
import service.GestionCompteLocal;

@Path("/comptb")
public class CompteBusinessRessources {
@Inject
GestionCompteLocal ejb;
@POST
@Consumes("application/json")
public String addCompte(CompteBusiness m){
	if(ejb.addCompte(m))
	return "success";
	return "fail";
	}

@GET
@Produces("application/json")
public List<CompteBusiness> FindAllAccounts()
{return ejb.findAllAccountb();}


}
