package domain;

import domain.Compte;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: CompteCourant
 *
 */
@Entity
@XmlRootElement
@NamedQuery(name="findAllCourant",query="select a from CompteCourant a")
public class CompteCourant extends Compte implements Serializable {

	private double fraisRetrait;
	private double fraisCheque;
	private double fraisGab;
	private double decouvertAutorise;
	private double dureeDecouvert;
	private double toleranceDecouvert;

	public CompteCourant(int rIB, String succursale, int numSuccursale,
			int solde, String ville, int codePostale, Date dateCreation,
			String etat, double fraisMensuel, double fraisRetrait,
			double fraisCheque, double fraisGab, double decouvertAutorise,
			double dureeDecouvert, double toleranceDecouvert,
			String descriptionDecouvert) {
		super(rIB, succursale, numSuccursale, solde, ville, codePostale,
				dateCreation, etat, fraisMensuel);
		this.fraisRetrait = fraisRetrait;
		this.fraisCheque = fraisCheque;
		this.fraisGab = fraisGab;
		this.decouvertAutorise = decouvertAutorise;
		this.dureeDecouvert = dureeDecouvert;
		this.toleranceDecouvert = toleranceDecouvert;
		this.descriptionDecouvert = descriptionDecouvert;
	}

	private String descriptionDecouvert;

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public double getDureeDecouvert() {
		return dureeDecouvert;
	}

	public void setDureeDecouvert(double dureeDecouvert) {
		this.dureeDecouvert = dureeDecouvert;
	}

	public double getToleranceDecouvert() {
		return toleranceDecouvert;
	}

	public void setToleranceDecouvert(double toleranceDecouvert) {
		this.toleranceDecouvert = toleranceDecouvert;
	}

	public String getDescriptionDecouvert() {
		return descriptionDecouvert;
	}

	public void setDescriptionDecouvert(String descriptionDecouvert) {
		this.descriptionDecouvert = descriptionDecouvert;
	}

	private static final long serialVersionUID = 1L;

	public CompteCourant() {
		super();
	}

	public double getFraisRetrait() {
		return this.fraisRetrait;
	}

	public void setFraisRetrait(double fraisRetrait) {
		this.fraisRetrait = fraisRetrait;
	}

	public double getFraisCheque() {
		return this.fraisCheque;
	}

	public void setFraisCheque(double fraisCheque) {
		this.fraisCheque = fraisCheque;
	}

	public double getFraisGab() {
		return this.fraisGab;
	}

	public void setFraisGab(double fraisGab) {
		this.fraisGab = fraisGab;
	}

}
