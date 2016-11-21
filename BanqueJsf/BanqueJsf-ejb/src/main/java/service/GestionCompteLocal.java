package service;

import java.util.List;

import javax.ejb.Local;

import domain.Compte;
import domain.CompteBusiness;
import domain.CompteCourant;
import domain.CompteEpargne;
import domain.CompteMineur;

@Local
public interface GestionCompteLocal {


	public Boolean addCompte(Compte compte);
	
	public Boolean addCompte(CompteCourant comptec);
	
	public Boolean addCompte(CompteEpargne compteep);
	
	public Boolean addCompte(CompteBusiness compteb);
	
	public Boolean updateCompte(Compte compte);
	public Boolean deleteCompte(Compte compte);
	public Compte findAccountById(int idCompte);
	public List<Compte> findAllAccount();
	public List<CompteCourant> findAllAccountc();
	
	public List<CompteEpargne> findAllAccounte();
	
	public List<CompteBusiness> findAllAccountb();
	public List<CompteMineur> findAllAccountm();

public  CompteEpargne findAccountByRib(int rib);

}
