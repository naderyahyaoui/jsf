package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Reclamation;

@Remote
public interface GestionReclamationRemote {
	
	public boolean ajouterReclamation(Reclamation rec);
	public boolean supprimerReclamation(Reclamation rec);
	public boolean metterAjourReclamation(Reclamation rec);
	public Reclamation rechercherReclamationById(int id);
	public List<Reclamation> afficherReclamation();

}
