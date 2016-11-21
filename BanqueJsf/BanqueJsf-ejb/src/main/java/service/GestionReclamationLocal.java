package service;

import java.util.List;

import javax.ejb.Local;

import domain.Reclamation;


@Local
public interface GestionReclamationLocal {
	
	public boolean ajouterReclamation(Reclamation rec);
	public boolean supprimerReclamation(Reclamation rec);
	public boolean metterAjourReclamation(Reclamation rec);
	public Reclamation rechercherReclamationById(int id);
	public List<Reclamation> afficherReclamation();
	//public Reclamation rechercherUtilisateurByLogin(Reclamation rec);
	//public void authentification();
	
	
	//public Utilisateur authentificate(String login, String password);
	//public Utilisateur findByLogin(String login );

}
