package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import domain.Credit;

/**
 * Session Bean implementation class ManageCredit
 */
@Stateless
@LocalBean
public class ManageCredit implements ManageCreditRemote, ManageCreditLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public ManageCredit() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addCredit(Credit credit) {
		try {
			em.merge(credit);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateCredit(Credit credit) {
		try {
			em.merge(credit);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteCredit(Credit credit) {
		try {
			em.remove(em.merge(credit));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Credit findCreditById(int idCredit) {
		Credit credit=null;
		try {
			credit=em.find(Credit.class,idCredit);
			
		} catch (Exception e) {
			
		}
		return credit;
	}

	@Override
	public List<Credit> findAllCredits() {
		Query query =em.createQuery("select c from Credit c");
		return query.getResultList();
	}

}
