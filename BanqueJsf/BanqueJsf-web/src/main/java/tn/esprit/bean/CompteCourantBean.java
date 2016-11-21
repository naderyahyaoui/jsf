package tn.esprit.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.GestionCompteLocal;
import domain.CompteCourant;


@ManagedBean(name="ccptBean")
@ViewScoped
public class CompteCourantBean {
	@EJB
	private GestionCompteLocal compteServiceLocal;
private List<CompteCourant> listComptec;
private boolean formDisplayed = false;
private CompteCourant cpt = new CompteCourant();
@PostConstruct
public void init() {
	listComptec = compteServiceLocal.findAllAccountc();


}

public void add() {
compteServiceLocal.addCompte(cpt);
}

public String doSaveOrUpdate() {
	String navTo = null;
	compteServiceLocal.updateCompte(cpt);
	listComptec = compteServiceLocal.findAllAccountc();
	formDisplayed = false;
	return navTo;
}

public String doRemove() {
	String navTo = null;
	compteServiceLocal.deleteCompte(cpt);
	listComptec = compteServiceLocal.findAllAccountc();
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
	cpt= new CompteCourant();
	formDisplayed = false;
	return navTo;
}

public List<CompteCourant> getListComptec() {
	return listComptec;
}

public void setListComptec(List<CompteCourant> listComptec) {
	this.listComptec = listComptec;
}

public boolean isFormDisplayed() {
	return formDisplayed;
}

public void setFormDisplayed(boolean formDisplayed) {
	this.formDisplayed = formDisplayed;
}

public CompteCourant getCpt() {
	return cpt;
}

public void setCpt(CompteCourant cpt) {
	this.cpt = cpt;
}

public GestionCompteLocal getCompteServiceLocal() {
	return compteServiceLocal;
}
public void setCompteServiceLocal(GestionCompteLocal compteServiceLocal) {
	this.compteServiceLocal = compteServiceLocal;
}

public List<CompteCourant> getListCompte() {
	return listComptec;
}

public void setListCompte(List<CompteCourant> listCompte) {
	this.listComptec = listCompte;
}


}
