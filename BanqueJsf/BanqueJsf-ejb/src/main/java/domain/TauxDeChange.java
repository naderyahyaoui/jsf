package domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TauxDeChange
 *
 */
@Entity

public class TauxDeChange implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int idTauxDechange;
	private String currency;
	private double coutAcheteur;
	private double coutVendeur;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private AgentBancaire agent;
	public TauxDeChange() {
		super();
	}   
	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}   
	public double getCoutAcheteur() {
		return this.coutAcheteur;
	}

	public void setCoutAcheteur(double coutAcheteur) {
		this.coutAcheteur = coutAcheteur;
	}   
	public double getCoutVendeur() {
		return this.coutVendeur;
	}

	public void setCoutVendeur(double coutVendeur) {
		this.coutVendeur = coutVendeur;
	}
	@Override
	public String toString() {
		return "TauxDeChange [idTauxDechange=" + idTauxDechange + ", currency="
				+ currency + ", coutAcheteur=" + coutAcheteur
				+ ", coutVendeur=" + coutVendeur + "]";
	}
	public TauxDeChange(String currency, double coutAcheteur, double coutVendeur) {
		super();
		this.currency = currency;
		this.coutAcheteur = coutAcheteur;
		this.coutVendeur = coutVendeur;
	}
	
   
}
