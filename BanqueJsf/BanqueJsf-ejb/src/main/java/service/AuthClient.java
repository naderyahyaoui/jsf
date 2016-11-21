package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Administrateur;
import domain.Client;
import domain.Utilisateur;

/**
 * Session Bean implementation class AuthClient
 */
@Stateless
@LocalBean
public class AuthClient implements AuthClientRemote, AuthClientLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public AuthClient() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur authentificate(String login, String password) {
		Utilisateur Type = null;
		Query query = em
				.createQuery("select e  from Utilisateur e where login=:l and password=:p");
		System.out.println("login : " + login);
		query.setParameter("l", login).setParameter("p", password);

		try {
			Type = (Utilisateur) query.getSingleResult();
			// if admin == director ......

		} catch (Exception e) {
			Type = null;
			// TODO: handle exception
		}
		System.out.println("tyyype : " + Type);
		return Type;

	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByProperty(String propertyName,
			final Object value) {

		try {
			final String queryString = "select model from Utilisateur model where model."
					+ propertyName + "= :propertyValue";
			Query query1 = em.createQuery(queryString);
			query1.setParameter("propertyValue", value);
			return query1.getResultList();
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return findByProperty("login", login).get(0);
	}

	@Override
	public void update(Utilisateur Employee) {
		em.merge(Employee);

	}

	@Override
	public Boolean addClient(Client client) {
		try {
			em.persist(client);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateClient(Client client) {
		try {
			em.merge(client);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteClient(Client client) {
		try {
			em.remove(em.merge(client));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Client findClientlById(int id) {
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> findAllClient() {
		Query query = em.createQuery("select d from Client d");
		return query.getResultList();
	}

	@Override
	public String testauthentification(Client u) {
		List <Client> cli= findAllClient(); 
		
		for (Client c :cli ){
			if(c.getPassword().equals(u.getPassword())&&c.getFirstName().equals(u.getFirstName()))
				
					return "exist";
			 
		}
		return "not exist";
	}
	@Override
	public List<Utilisateur> findAllUsers() {
		Query query = em.createQuery("select d from Utilisateur d");
		return query.getResultList();
	}

	@Override
	public String authentificationAndroid(Utilisateur u) {
      List <Utilisateur> cli= findAllUsers(); 
		
		for (Utilisateur c :cli ){
			if(c.getPassword().equals(u.getPassword())&&c.getFirstName().equals(u.getFirstName()))
				
					return "exist";
			 
		}
		return "not exist";
	}

}
