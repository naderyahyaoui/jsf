package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Reclamation;

/**
 * Session Bean implementation class GestionReclamation
 */

@Stateless
@LocalBean
public class GestionReclamation implements GestionReclamationRemote, GestionReclamationLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionReclamation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean ajouterReclamation(Reclamation rec) {
		try{
			em.persist(rec);
			return true;
		}catch(Exception e)
		{return false;}
		
	}

	@Override
	public boolean supprimerReclamation(Reclamation rec) {
		try{
		em.remove(em.merge(rec));
		return true;
		}
		catch (Exception e)
		{return false; }
	}

	@Override
	public boolean metterAjourReclamation(Reclamation rec) {
		try{
		em.merge(rec);
		return true;
		}catch(Exception e)
		{return false;}
	}

	@Override
	public Reclamation rechercherReclamationById(int id) {
		
		return em.find(Reclamation.class, id);
	}

	@Override
	public List<Reclamation> afficherReclamation() {
		Query query=em.createQuery("select d from Reclamation d");
		return query.getResultList();
	}

}
