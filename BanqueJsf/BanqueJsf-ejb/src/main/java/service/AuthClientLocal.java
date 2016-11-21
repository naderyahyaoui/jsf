package service;

import java.util.List;

import javax.ejb.Local;

import domain.Client;
import domain.Utilisateur;

@Local
public interface AuthClientLocal {
	
	public Utilisateur authentificate(String login, String password);
	public Utilisateur findByLogin(String login );
	public void update(Utilisateur admin);
	public String testauthentification(Client u);
	
	public Boolean addClient(Client client);
	public Boolean updateClient (Client client);
	public Boolean deleteClient(Client client);
	public Client findClientlById(int id);
	public List<Client> findAllClient();
	
	
	public List<Utilisateur> findAllUsers();
	public String authentificationAndroid(Utilisateur u);
	
}
