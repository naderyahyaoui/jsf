package service;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Compte;
import domain.CompteBusiness;
import domain.CompteCourant;
import domain.CompteEpargne;
import domain.CompteMineur;



/**
 * Session Bean implementation class GestionCompte
 */
@Stateful
@LocalBean
public class GestionCompte implements GestionCompteRemote, GestionCompteLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionCompte() {
        // TODO Auto-generated constructor stub
    }
 /**
  * this method allow the add of accounts
  */
	@Override
	public Boolean addCompte(Compte compte) {
		try {
			em.persist(compte);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 /**
	  * this method allow the update of accounts
	  */
	@Override
	public Boolean updateCompte(Compte compte) {
		try {
			em.merge(compte);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 /**
	  * this method allow the remove of accounts
	  */
	@Override
	public Boolean deleteCompte(Compte compte) {
		try {
			em.remove(em.merge(compte));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 /**
	  * this method allow to find one account by ID
	  */
	@Override
	public Compte findAccountById(int idCompte) {
		Compte compte=null;
		try {
			compte=em.find(Compte.class,idCompte);
			
		} catch (Exception e) {
			
		}
		return compte;
		
	}
	 /**
	  * this method allow to display accounts
	  */
	@Override
	public List<Compte> findAllAccount() {
		Query query =em.createQuery("select c from Compte c");
		return query.getResultList();
	}
	
	@Override
	public Boolean addCompte(CompteCourant comptec) {
		try {
			em.persist(comptec);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean addCompte(CompteEpargne compteep) {
		try {
			em.persist(compteep);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public Boolean addCompte(CompteBusiness compteb) {
		try {
			em.persist(compteb);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<CompteEpargne> findAllAccounte() {
		return (List<CompteEpargne>) em.createNamedQuery("findAllEpargne").getResultList();
	}
	@Override
	public List<CompteBusiness> findAllAccountb() {
		return (List<CompteBusiness>) em.createNamedQuery("findAllBusiness").getResultList();
		}

	public List<CompteCourant> findAllAccountc() {
		return (List<CompteCourant>) em.createNamedQuery("findAllCourant").getResultList();
		}
	public List<CompteMineur> findAllAccountm() {
		return (List<CompteMineur>) em.createNamedQuery("findAllMineur").getResultList();
		}
	
	public CompteEpargne findAccountByRib(int type) {
			CompteEpargne found = null;
			Query query = em
					.createQuery("select t from compte t where t.RIB=:type");
			query.setParameter("type", type);
			try {
				found = (CompteEpargne) query.getSingleResult();
			} catch (Exception e) {
				Logger.getLogger(this.getClass().getName()).log(Level.INFO,
						"no type found");
			}

			return found;
		}
}
