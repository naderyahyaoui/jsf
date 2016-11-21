package tn.esprit.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import domain.CompteMineur;
import service.GestionCompteLocal;


@ManagedBean(name="mcptBean")
@ViewScoped
public class CompteMineurBean {
	@EJB
	private GestionCompteLocal compteServiceLocal;
private List<CompteMineur> listCompte;
private boolean formDisplayed = false;
private CompteMineur cpt= new CompteMineur();
@PostConstruct
public void init() {
	listCompte = compteServiceLocal.findAllAccountm();


}

public void add() {
compteServiceLocal.addCompte(cpt);
}


public String doSaveOrUpdate() {
	String navTo = null;
	compteServiceLocal.updateCompte(cpt);
	listCompte = compteServiceLocal.findAllAccountm();
	formDisplayed = false;
	return navTo;
}

public String doRemove() {
	String navTo = null;
	compteServiceLocal.deleteCompte(cpt);
	listCompte = compteServiceLocal.findAllAccountm();
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
	cpt= new CompteMineur();
	formDisplayed = false;
	return navTo;
}


public boolean isFormDisplayed() {
	return formDisplayed;
}

public void setFormDisplayed(boolean formDisplayed) {
	this.formDisplayed = formDisplayed;
}

public CompteMineur getCpt() {
	return cpt;
}

public void setCpt(CompteMineur cpt) {
	this.cpt = cpt;
}

public GestionCompteLocal getCompteServiceLocal() {
	return compteServiceLocal;
}
public void setCompteServiceLocal(GestionCompteLocal compteServiceLocal) {
	this.compteServiceLocal = compteServiceLocal;
}

public List<CompteMineur> getListCompte() {
	return listCompte;
}

public void setListCompte(List<CompteMineur> listCompte) {
	this.listCompte = listCompte;
}

}
