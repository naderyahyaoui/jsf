package services.authentification;



import javax.ejb.Local;

import domain.Utilisateur;


@Local
public interface AuthentificationServiceLocal {
	public Utilisateur authentifier(String login, String pwd);

	//boolean existeEmail(String login);

	void sauvegarderUtilisateur(Utilisateur utilisateur);
	

}
