package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import domain.Reclamation;
import service.GestionReclamationLocal;

@ManagedBean
@ViewScoped
public class GestionReclamation {
@EJB
GestionReclamationLocal local;
private List<Reclamation> reclamations;
private Reclamation reclamation=new Reclamation();

public GestionReclamation()
{	
}
public GestionReclamationLocal getLocal() {
	return local;
}
public void setLocal(GestionReclamationLocal local) {
	this.local = local;
}
public Reclamation getReclamation() {
	return reclamation;
}
public void setReclamation(Reclamation reclamation) {
	this.reclamation = reclamation;
}



public List<Reclamation> getReclamations() {
	return reclamations;
}
public void setReclamations(List<Reclamation> reclamations) {
	this.reclamations = reclamations;
}
//Reclamation Simple CRUD Create,Read,Update,Delete 
@PostConstruct
public void readReclamtions()
{   
	reclamations=local.afficherReclamation();
}
public String createReclamation()
{
	local.ajouterReclamation(reclamation);
	readReclamtions();
	return "";
}
public String updateReclamation()
{
	local.metterAjourReclamation(reclamation);
	readReclamtions();
	return "";
}
public String deleteReclamationByReclamation(Reclamation reclamation)
{
	local.supprimerReclamation(reclamation);
	readReclamtions();
	return "";
}
public String deleteReclamation()
{
	local.supprimerReclamation(reclamation);
	readReclamtions();
	return "";
}
public String viderChamps()
{
	reclamation=new Reclamation();	
return "";
}
//End CRUD
}


