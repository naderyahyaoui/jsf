package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Compte
 *
 */

@Entity
@XmlRootElement
public class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCompte;
	private int RIB;
	private String succursale;
	private int numSuccursale;
	private int solde;
	@ManyToOne()
	private Client client;
	public Compte(int rIB, String succursale, int numSuccursale, int solde,
			String ville, int codePostale, Date dateCreation, String etat,
			double fraisMensuel) {
		super();
		RIB = rIB;
		this.succursale = succursale;
		this.numSuccursale = numSuccursale;
		this.solde = solde;
		this.ville = ville;
		this.codePostale = codePostale;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.fraisMensuel = fraisMensuel;
	}

	private String ville;
	private int codePostale;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String etat;
	private double fraisMensuel;

	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public int getRIB() {
		return RIB;
	}

	public void setRIB(int rIB) {
		RIB = rIB;
	}

	public String getSuccursale() {
		return succursale;
	}

	public void setSuccursale(String succursale) {
		this.succursale = succursale;
	}

	public int getNumSuccursale() {
		return numSuccursale;
	}

	public void setNumSuccursale(int numSuccursale) {
		this.numSuccursale = numSuccursale;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getFraisMensuel() {
		return fraisMensuel;
	}

	public void setFraisMensuel(double fraisMensuel) {
		this.fraisMensuel = fraisMensuel;
	}

}
