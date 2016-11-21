package domain;

import domain.Compte;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: CompteBusiness
 *
 */
@Entity
@XmlRootElement
@NamedQuery(name="findAllBusiness",query="select a from CompteBusiness a")
public class CompteBusiness extends Compte implements Serializable {

	private String nomEntreprise;
	private String activite;
	private String adresse;
	private String description;
	private String type;
	private static final long serialVersionUID = 1L;

	public CompteBusiness() {
		super();
	}

	public String getNomEntreprise() {
		return this.nomEntreprise;
	}

	public CompteBusiness(int rIB, String succursale, int numSuccursale,
			int solde, String ville, int codePostale, Date dateCreation,
			String etat, double fraisMensuel, String nomEntreprise,
			String activite, String adresse, String description, String type) {
		super(rIB, succursale, numSuccursale, solde, ville, codePostale,
				dateCreation, etat, fraisMensuel);
		this.nomEntreprise = nomEntreprise;
		this.activite = activite;
		this.adresse = adresse;
		this.description = description;
		this.type = type;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getActivite() {
		return this.activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
