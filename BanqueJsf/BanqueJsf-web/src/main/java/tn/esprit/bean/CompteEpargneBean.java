package tn.esprit.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import domain.Compte;
import domain.CompteEpargne;
import domain.Virement;
import service.GestionCompteLocal;



@ManagedBean(name="ecptBean")
@SessionScoped
public class CompteEpargneBean {
@EJB
GestionCompteLocal compteServiceLocal;
private List<CompteEpargne> listCompte;
private CompteEpargne cpt= new CompteEpargne();
private boolean formDisplayed = false;
private CompteEpargne cptFrom=new CompteEpargne();
private Compte cptTo=new CompteEpargne();
private Virement v= new Virement();

@PostConstruct
public void init()  {
	listCompte = compteServiceLocal.findAllAccounte();


}


public void add() {
compteServiceLocal.addCompte(cpt);
}

public GestionCompteLocal getCompteServiceLocal() {
	return compteServiceLocal;
}


public void setCompteServiceLocal(GestionCompteLocal compteServiceLocal) {
	this.compteServiceLocal = compteServiceLocal;
}


public String doSaveOrUpdate() {
	String navTo = null;
	compteServiceLocal.updateCompte(cpt);
	//listCompte = compteServiceLocal.findAllAccounte();
//	formDisplayed = false;
	return navTo;
}
public String doAdd() {
	String navTo = null;
	compteServiceLocal.addCompte(cpt);
	//listCompte = compteServiceLocal.findAllAccounte();
//	formDisplayed = false;
	return navTo;
}
public String doRemove() {
	String navTo = null;
	compteServiceLocal.deleteCompte(cpt);
	listCompte = compteServiceLocal.findAllAccounte();
	formDisplayed = false;
	return navTo;
}

public String doNew() {
	String navTo = null;
	formDisplayed = true;
	return navTo;
}

public String doCancel() {
	String navTo = null;
	cpt= new CompteEpargne();
	formDisplayed = false;
	return navTo;
}

public void finish()
{cptFrom= compteServiceLocal.findAccountByRib(v.getFromCompteRib());
cptFrom.setSolde(v.getSolde());
compteServiceLocal.updateCompte(cptFrom);


//cptTo= compteServiceLocal.findAccountByRib(v.getFromCompteRib());
//cptTo.setSolde(cptTo.getSolde()-v.getSolde());
//compteServiceLocal.updateCompte(cptTo);
}


public CompteEpargne getCpt() {
	return cpt;
}

public void setCpt(CompteEpargne cpt) {
	this.cpt = cpt;
}

public List<CompteEpargne> getListCompte() {
	return listCompte;
}

public void setListCompte(List<CompteEpargne> listCompte) {
	this.listCompte = listCompte;
}

public boolean isFormDisplayed() {
	return formDisplayed;
}

public void setFormDisplayed(boolean formDisplayed) {
	this.formDisplayed = formDisplayed;
}


public CompteEpargne getCptFrom() {
	return cptFrom;
}


public void setCptFrom(CompteEpargne cptFrom) {
	this.cptFrom = cptFrom;
}


public Compte getCptTo() {
	return cptTo;
}


public void setCptTo(Compte cptTo) {
	this.cptTo = cptTo;
}


public Virement getV() {
	return v;
}


public void setV(Virement v) {
	this.v = v;
}


}
