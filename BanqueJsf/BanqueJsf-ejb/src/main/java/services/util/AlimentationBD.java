package services.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;







import services.authentification.AuthentificationServiceLocal;
import domain.Administrateur;
import domain.Client;
import domain.Financier;
import domain.Utilisateur;




/**
 * Session Bean implementation class AlimentationBD
 */
@Singleton
@Startup
public class AlimentationBD {

	@EJB
	AuthentificationServiceLocal authentificationService;


	public AlimentationBD() {
	}

	@PostConstruct
	public void addData() {
		
	
		
		
			//Utilisateur client = new Client("client", "client");
			//authentificationService.sauvegarderUtilisateur(client);
//
//		
//		
//			Utilisateur financier = new Financier("financier","finacier");
//			authentificationService.sauvegarderUtilisateur(financier);
//
//		
//		
//		
//			Utilisateur admin = new Administrateur("admin", "admin");
//            authentificationService.sauvegarderUtilisateur(admin);

		
//		Utilisateur admin = new Utilisateur("a", "a");
//		  authentificationService.sauvegarderUtilisateur(admin);
	}
}
