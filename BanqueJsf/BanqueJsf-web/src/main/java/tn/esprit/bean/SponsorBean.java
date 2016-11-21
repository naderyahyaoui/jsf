package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.SponsorServiceLocal;
import domain.Sponsor;







@ManagedBean
@ViewScoped
public class SponsorBean {

	private Sponsor spons = new Sponsor();

	@EJB
	private SponsorServiceLocal sponsorServiceLocal;

	private List<Sponsor> listsponsors;
	private List<Sponsor> filtredSponsor;

	private boolean formDisplayed = false;

	@PostConstruct
	public void initspon() {
		spons = new Sponsor();
		listsponsors = sponsorServiceLocal.findAllSponsors();
		formDisplayed = false;
	}

	public void doSaveOrUpdate() {
	
		sponsorServiceLocal.saveSponsor(spons);
		listsponsors = sponsorServiceLocal.findAllSponsors();
		formDisplayed = false;
	
	}

	public void doRemove() {
		
		sponsorServiceLocal.removeSponsor(spons);
		listsponsors = sponsorServiceLocal.findAllSponsors();
		formDisplayed = false;
	
	}

	public void doNew() {
		spons = new Sponsor();
		formDisplayed = true;
		
	}

	public void doCancel() {
		

		formDisplayed = false;
		
	}

	public void onRowSelect(){
		formDisplayed = true;
		
	}
public void onFilter(){
	
	spons = new Sponsor();
	formDisplayed = false;
}
	

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public Sponsor getSpons() {
		return spons;
	}

	public void setSpons(Sponsor spons) {
		this.spons = spons;
	}

	public SponsorServiceLocal getSponsorServiceLocal() {
		return sponsorServiceLocal;
	}

	public void setSponsorServiceLocal(SponsorServiceLocal sponsorServiceLocal) {
		this.sponsorServiceLocal = sponsorServiceLocal;
	}

	public List<Sponsor> getListsponsors() {
		return listsponsors;
	}

	public void setListsponsors(List<Sponsor> listsponsors) {
		this.listsponsors = listsponsors;
	}

	public List<Sponsor> getFiltredSponsor() {
		return filtredSponsor;
	}

	public void setFiltredSponsor(List<Sponsor> filtredSponsor) {
		this.filtredSponsor = filtredSponsor;
	}
	
}
