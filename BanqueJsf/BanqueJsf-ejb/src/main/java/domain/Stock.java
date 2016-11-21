package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity

public class Stock implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Stock;
	private String materiel;
	private String nature;
	private double prix;
	private static final long serialVersionUID = 1L;

	
	 
	public Stock(String materiel, String nature, double prix) {
		super();
		this.materiel = materiel;
		this.nature = nature;
		this.prix = prix;
	}
	public Stock() {
		super();
	}   
	public long getId_Stock() {
		return this.id_Stock;
	}

	public void setId_Stock(long id_Stock) {
		this.id_Stock = id_Stock;
	}   
	public String getMateriel() {
		return this.materiel;
	}

	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}   
	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}   
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
   
}
