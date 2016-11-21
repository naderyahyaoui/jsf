package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Client;

import domain.Utilisateur;

@Remote
public interface AuthClientRemote {
	public Utilisateur authentificate(String login, String password);
	public Utilisateur findByLogin(String login );
	public void update(Utilisateur admin);
	
	
	public Boolean addClient(Client client);
	public Boolean updateClient (Client client);
	public Boolean deleteClient(Client client);
	public Client findClientlById(int id);
	public List<Client> findAllClient();
	
	


}
