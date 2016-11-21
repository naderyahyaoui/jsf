package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Sponsor;


@Stateless
public class SponsorService implements SponsorServiceLocal {
	@PersistenceContext
	private EntityManager em;
	
	public SponsorService() {
	}
	
	@Override
	public Sponsor createSponsor(Sponsor sponsor) {
		em.persist(sponsor);
		return sponsor;
	}

	@Override
	public void saveSponsor(Sponsor sponsor) {
		em.merge(sponsor);
		
	}

	@Override
	public void removeSponsor(Sponsor sponsor) {
		em.remove(em.merge(sponsor));
		
	}

	@Override
	public List<Sponsor> findAllSponsors() {
		return em.createQuery("select p from Sponsor p", Sponsor.class)
				.getResultList();
	}

	
	
	

}
