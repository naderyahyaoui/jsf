package services.authentification;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domain.Utilisateur;



/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
public class AuthentificationService implements AuthentificationServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public AuthentificationService() {
		// TODO Auto-generated constructor stub
	}
//	public Utilisateur authentifier(String login, String password) {
//		Utilisateur found = null;
//		String jpql = "select u from Utilisateur u where u.login=:login and u.password=:password";
//		TypedQuery<Utilisateur> query = entityManager.createQuery(jpql, Utilisateur.class);
//		query.setParameter("login", login);
//		query.setParameter("password", password);
//		try {
//			found = query.getSingleResult();
//		} catch (Exception ex) {
//			Logger.getLogger(AuthentificationService.class.getName()).log(
//					Level.WARNING,
//					"authentication attempt failure with login=" + login
//							+ " and password=" + password);
//		}
//		return found;
//	}
	public Utilisateur authentifier(String login, String password) {
		Utilisateur utilisateur = null;
		Query query = entityManager
				.createQuery("select u from Utilisateur u where u.login=:login and u.password=:password");
		query.setParameter("login", login).setParameter("password", password);
		try {
			utilisateur = (Utilisateur) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with login="+login+" and password="+password);
		}
		return utilisateur;
	}

//	public boolean existeEmail(String login) {
//		boolean exists = false;
//		String jpql = "select case when (count(u) > 0)  then true else false end from Utilisateur u where u.login=:login";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter("login", login);
//		exists = (Boolean) query.getSingleResult();
//		return exists;
//
//	}

	public void sauvegarderUtilisateur(Utilisateur utilisateur) {
		entityManager.merge(utilisateur);
	}



}
