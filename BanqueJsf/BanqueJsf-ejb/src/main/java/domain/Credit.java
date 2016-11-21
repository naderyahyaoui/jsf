package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Credit
 *
 */
@Entity
public class Credit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCredit;
	private String Type;
	
	public Credit(String type, double montantSouhaite, Integer dureeEnMois,
			double revenuMensuelNet, String tauxInteret, double debitEnMois,
			String libelle) {
		super();
		Type = type;
		this.montantSouhaite = montantSouhaite;
		DureeEnMois = dureeEnMois;
		RevenuMensuelNet = revenuMensuelNet;
		this.tauxInteret = tauxInteret;
		DebitEnMois = debitEnMois;
		this.libelle = libelle;
	}

	private double montantSouhaite;
	private Integer DureeEnMois;
	private double RevenuMensuelNet;
	private String tauxInteret;
	private double DebitEnMois;
	private String libelle;
	private static final long serialVersionUID = 1L;

	public Credit() {
		super();
	}

	public long getIdCredit() {
		return this.idCredit;
	}

	public void setIdCredit(long idCredit) {
		this.idCredit = idCredit;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public double getMontantSouhaite() {
		return this.montantSouhaite;
	}

	public void setMontantSouhaite(double montantSouhaite) {
		this.montantSouhaite = montantSouhaite;
	}

	public Integer getDureeEnMois() {
		return this.DureeEnMois;
	}

	public void setDureeEnMois(Integer DureeEnMois) {
		this.DureeEnMois = DureeEnMois;
	}

	public double getRevenuMensuelNet() {
		return this.RevenuMensuelNet;
	}

	public void setRevenuMensuelNet(double RevenuMensuelNet) {
		this.RevenuMensuelNet = RevenuMensuelNet;
	}

	public String getTauxInteret() {
		return this.tauxInteret;
	}

	public void setTauxInteret(String tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public double getDebitEnMois() {
		return this.DebitEnMois;
	}

	public void setDebitEnMois(double DebitEnMois) {
		this.DebitEnMois = DebitEnMois;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
