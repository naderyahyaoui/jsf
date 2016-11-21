package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sponsor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_spons;
	private String nom;
	 private String description;
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_spons() {
		return id_spons;
	}
	public void setId_spons(int id_spons) {
		this.id_spons = id_spons;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	 
	 
	 
	
}
