package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Utilisateur;





/**
 * Session Bean implementation class AuthEmp
 */
@Stateless
@LocalBean
public class AuthEmp implements AuthEmpRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public AuthEmp() {
        // TODO Auto-generated constructor stub
    }

    public  Utilisateur authentificate(String login, String password) {
		Utilisateur Type = null;
		Query query = entityManager
		.createQuery("select e  from Utilisateur e where login=:l and password=:p");
		System.out.println("login : " + login );
		query.setParameter("l",login).setParameter("p", password);
	
		try {
			Type = (Utilisateur) query.getSingleResult();
			//if admin == director ......

		} catch (Exception e) {
			Type = null;
			// TODO: handle exception
		}
		System.out.println("tyyype : " + Type );
		return Type;

	}
	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByProperty(String propertyName, final Object value) {
		
		try {
			final String queryString = "select model from Utilisateur model where model."
					+ propertyName + "= :propertyValue";
			Query query1 = entityManager.createQuery(queryString);
			query1.setParameter("propertyValue", value);
			return query1.getResultList();
		} catch (RuntimeException re) {
		
			throw re;
		}
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return findByProperty("login", login).get(0) ;
	}

	@Override
	public void update(Utilisateur Employee) {
		entityManager.merge(Employee) ;
		
	}

	
}