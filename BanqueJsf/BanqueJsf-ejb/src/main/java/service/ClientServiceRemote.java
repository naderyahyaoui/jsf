package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Client;



@Remote
public interface ClientServiceRemote
{
	Boolean addClient(Client client);
	Boolean updateClient (Client client);
	Boolean deleteClient(Client client);
	Client findClientlById(Integer id);
	List<Client> findAllClient();
	

}
