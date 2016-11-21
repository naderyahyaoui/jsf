package domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Budgetisation
 *
 */
@Entity

public class Budgetisation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBudgetisation;
	private double depot;
	private double credit;
	private double tauxInteret;
	private String mois;
	private String date;
	private double montant;
	private String partenaire;
	private double budgetBanque;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private AgentBancaire agent;

	public Budgetisation() {
		super();
	}   
	
	public double getDepot() {
		return this.depot;
	}

	public void setDepot(double depot) {
		this.depot = depot;
	}   
	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}   
	public double getTauxInteret() {
		return this.tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}   
	public String getMois() {
		return this.mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}   
	public String getPartenaire() {
		return this.partenaire;
	}

	public void setPartenaire(String partenaire) {
		this.partenaire = partenaire;
	}   
	public double getBudgetBanque() {
		return this.budgetBanque;
	}

	public void setBudgetBanque(double budgetBanque) {
		this.budgetBanque = budgetBanque;
	}

	@Override
	public String toString() {
		return "Budgetisation [idBudgetisation=" + idBudgetisation + ", depot="
				+ depot + ", credit=" + credit + ", tauxInteret=" + tauxInteret
				+ ", mois=" + mois + ", date=" + date + ", montant=" + montant
				+ ", partenaire=" + partenaire + ", budgetBanque="
				+ budgetBanque + "]";
	}
   
}
