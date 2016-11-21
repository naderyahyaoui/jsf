package ressources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import service.AuthClientLocal;
import domain.Client;
import domain.Compte;
import domain.Utilisateur;

@Path("client")
public class ClientService {
	@Inject
	AuthClientLocal ejb;
	static Client client;
	static List<Client> clients=new ArrayList<Client>();




	@DELETE
	@Consumes("application/json")
	public void supp(@QueryParam(value="idUser")int idUser)
	{
		ejb.deleteClient((ejb.findClientlById(idUser)));
		}


	@GET
	@Produces("application/json")
	public List<Client> getAll() {
		return ejb.findAllClient();
	}


	
	@POST
	@Consumes("application/json")
	public void ajouterClient(Client c)
	{
		
		ejb.addClient(c);
		
		
	}
	

	@PUT
	@Path("modifier")
	@Consumes("application/json")
	public String modif(Client client)
	{
		ejb.updateClient(client);
		return "modif";
	
	}
		
	
	@POST
	@Path("authentification")
	@Consumes("application/json")
	public String authentif(Client client)
	{
		return ejb.testauthentification(client);
	}

	
	
}
