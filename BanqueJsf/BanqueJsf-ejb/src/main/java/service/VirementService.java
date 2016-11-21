package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import domain.Virement;

/**
 * Session Bean implementation class VirementService
 */
@Stateless
@LocalBean
public class VirementService implements VirementServiceLocal {

    @PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
	
    public VirementService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addVirement(Virement v) {
		try {
			em.persist(v);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Virement findById(int idV) {
	Virement v=null;
		try {
			v=em.find(Virement.class,idV);
			
		} catch (Exception e) {
			
		}
		return v;
	
	}

	@Override
	public List<Virement> findAll() {
		Query query =em.createQuery("select c from Virement c");
		return query.getResultList();
	
	}

}
