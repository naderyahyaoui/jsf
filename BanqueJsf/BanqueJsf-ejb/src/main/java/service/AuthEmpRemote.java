package service;

import javax.ejb.Remote;

import domain.Utilisateur;






@Remote
public interface AuthEmpRemote {
	public Utilisateur authentificate(String login, String password);

	public Utilisateur findByLogin(String login );
	
	public void update(Utilisateur admin);
	

}
