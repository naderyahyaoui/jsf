package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;





/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@XmlRootElement
public class Client extends Utilisateur implements Serializable {

	
	private Date dateNaissance;
	private String lieuNassance;
	private String etatCivil;
	private String nationnalite;
	private int cin;

	
	
	
	public Client(String firstName, String lastName, String adress, String tel,
			String mail, Date dateNaissance, String lieuNassance,
			String etatCivil, String nationnalite, int cin, String login,
			String password, Date dateDelivrance, String lieuDelivrance,
			String profession) {
		super(firstName, lastName, adress, tel, mail);
		this.dateNaissance = dateNaissance;
		this.lieuNassance = lieuNassance;
		this.etatCivil = etatCivil;
		this.nationnalite = nationnalite;
		this.cin = cin;
		
		this.dateDelivrance = dateDelivrance;
		this.lieuDelivrance = lieuDelivrance;
		this.profession = profession;
	}
	private Date dateDelivrance;
	private String lieuDelivrance;
	private String profession;
	private static final long serialVersionUID = 1L;
//	@OneToMany(mappedBy="client")
//	private List<Compte> comptes ;
	public Client(String login,
			String password) {
		super(login, password);
		
	}
	public Client() {
		super();
	}   


	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}   
	public String getLieuNassance() {
		return this.lieuNassance;
	}

	public void setLieuNassance(String lieuNassance) {
		this.lieuNassance = lieuNassance;
	}   
	public String getEtatCivil() {
		return this.etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}   
	public String getNationnalite() {
		return this.nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}   
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public Date getDateDelivrance() {
		return this.dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}   
	public String getLieuDelivrance() {
		return this.lieuDelivrance;
	}

	public void setLieuDelivrance(String lieuDelivrance) {
		this.lieuDelivrance = lieuDelivrance;
	}   
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
//	public List<Compte> getComptes() {
//		return comptes;
//	}
//	public void setComptes(List<Compte> comptes) {
//		this.comptes = comptes;
//	}
   
}
