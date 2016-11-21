package service;

import java.util.List;

import javax.ejb.Local;

import domain.Client;



@Local
public interface ClientServiceLocal 
{
	Boolean addClient(Client client);
	Boolean updateClient (Client client);
	Boolean deleteClient(Client client);
	Client findClientlById(Integer id);
	List<Client> findAllClient();
	

}
