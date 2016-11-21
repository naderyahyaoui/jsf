package ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import domain.Compte;
import service.GestionCompteLocal;

@Path("/compt")
public class CompteRessourses {

	@Inject
	GestionCompteLocal ejb;
	
	@DELETE
	@Consumes("application/json")
	public void suppCompte(@QueryParam(value="id")int id)
	{
		ejb.deleteCompte(ejb.findAccountById(id));}
	
	
	@GET
	@Produces("application/json")
	public List<Compte> FindAllAccounts()
	{return ejb.findAllAccount();}

	@POST
	@Consumes("application/json")
	public String addCompte(Compte m){
		if(ejb.addCompte(m))
		return "success";
		return "fail";
		}
	
	@PUT
	@Consumes("application/json")
	public String updateCompte(Compte c){
		if(ejb.updateCompte(c))
			return "success";
			return "fail";
			
	}

}
