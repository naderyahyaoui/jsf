package domain;

import domain.Compte;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: CompteEpargne
 *
 */
@Entity
@XmlRootElement
@NamedQuery(name="findAllEpargne",query="select a from CompteEpargne a")
public class CompteEpargne extends Compte implements Serializable {

	private double interetMensuel;
	private String possessionLivret;
	private String type;
	private String libelle;
	private static final long serialVersionUID = 1L;

	public CompteEpargne() {
		super();
	}

	public double getInteretMensuel() {
		return this.interetMensuel;
	}

	public void setInteretMensuel(double interetMensuel) {
		this.interetMensuel = interetMensuel;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getPossessionLivret() {
		return this.possessionLivret;
	}

	public void setPossessionLivret(String possessionLivret) {
		this.possessionLivret = possessionLivret;
	}

	public CompteEpargne(int rIB, String succursale, int numSuccursale,
			int solde, String ville, int codePostale, Date dateCreation,
			String etat, double fraisMensuel, double interetMensuel,
			String possessionLivret, String type, String libelle) {
		super(rIB, succursale, numSuccursale, solde, ville, codePostale,
				dateCreation, etat, fraisMensuel);
		this.interetMensuel = interetMensuel;
		this.possessionLivret = possessionLivret;
		this.type = type;
		this.libelle = libelle;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
