package tn.esprit.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.GestionCompteLocal;
import domain.CompteBusiness;


@ManagedBean(name="bcptBean")
@ViewScoped
public class CompteBusinessBeans {
	@EJB
	private GestionCompteLocal compteServiceLocal;
private List<CompteBusiness> listCompteb;
private boolean formDisplayed = false;
private CompteBusiness cpt=new CompteBusiness();
@PostConstruct
public void init(){
	listCompteb = compteServiceLocal.findAllAccountb();


}

public String doSaveOrUpdate() {
	String navTo = null;
	compteServiceLocal.updateCompte(cpt);
	listCompteb = compteServiceLocal.findAllAccountb();
	formDisplayed = false;
	return navTo;
}

public String doRemove() {
	String navTo = null;
	compteServiceLocal.deleteCompte(cpt);
	listCompteb = compteServiceLocal.findAllAccountb();
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
	cpt= new CompteBusiness();
	formDisplayed = false;
	return navTo;
}



public List<CompteBusiness> getListCompteb() {
	return listCompteb;
}

public void setListCompteb(List<CompteBusiness> listCompteb) {
	this.listCompteb = listCompteb;
}

public boolean isFormDisplayed() {
	return formDisplayed;
}

public void setFormDisplayed(boolean formDisplayed) {
	this.formDisplayed = formDisplayed;
}

public CompteBusiness getCpt() {
	return cpt;
}

public void setCpt(CompteBusiness cpt) {
	this.cpt = cpt;
}

public GestionCompteLocal getCompteServiceLocal() {
	return compteServiceLocal;
}
public void setCompteServiceLocal(GestionCompteLocal compteServiceLocal) {
	this.compteServiceLocal = compteServiceLocal;
}

public List<CompteBusiness> getListCompte() {
	return listCompteb;
}

public void setListCompte(List<CompteBusiness> listCompte) {
	this.listCompteb = listCompte;
}


}
