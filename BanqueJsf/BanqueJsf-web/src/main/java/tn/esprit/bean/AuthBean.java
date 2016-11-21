package tn.esprit.bean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.Administrateur;
import domain.Client;
import domain.Financier;
import domain.Utilisateur;
import services.authentification.AuthentificationServiceLocal;

@ManagedBean
@SessionScoped
public class AuthBean {

	
	@EJB
	AuthentificationServiceLocal local;
	private Utilisateur user=new Utilisateur();
	private boolean loggedIn;
public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	//	private Etudiant etudiant=new Etudiant();
//	
//
//
//	private List<Etudiant> etudiants=new ArrayList<Etudiant>();
//	
//	public Etudiant getEtudiant() {
//		return etudiant;
//	}
//
//
//	public void setEtudiant(Etudiant etudiant) {
//		this.etudiant = etudiant;
//	}
//	 public List<Etudiant> getEtudiants() {
//		 etudiants=local.listerEtudiants();
//			return etudiants;
//			
//		}
//
//
//		public void setEtudiants(List<Etudiant> etudiants) {
//			this.etudiants = etudiants;
//		}
//
	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public String doLogin()
	
	{
		Utilisateur u=local.authentifier(user.getLogin(), user.getPassword());		
		user=u;
		if(u instanceof Administrateur)	
		{
			loggedIn = true;
			return"/template/espaces/indexAdmin?faces-redirect=true";	
		}
		if(u instanceof Financier)
		{
			loggedIn = true;
			return"/template/espaces/indexFinancier?faces-redirect=true";
		}
		if(u instanceof Client)
		{
			loggedIn = true;
			return"/template/espaces/indexClient?faces-redirect=true";
			
		}
		return "erreur";
	}
	public String doLogout() {
		String navigateTo = null;
		navigateTo = "/pages/login?faces-redirect=true";
		user = new Utilisateur();
		loggedIn = false;
		return navigateTo;
	}

	
}
