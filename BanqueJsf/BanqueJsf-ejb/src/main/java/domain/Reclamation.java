package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReclamation;
	private String mail;
	private String compte;
	private String titre;
	private String description;
	private String titulaire;
	private static final long serialVersionUID = 1L;

	public Reclamation() {
		super();
	}   
	public int getIdReclamation() {
		return this.idReclamation;
	}

	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}   
  
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getCompte() {
		return this.compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getTitulaire() {
		return this.titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}
	
   
}
