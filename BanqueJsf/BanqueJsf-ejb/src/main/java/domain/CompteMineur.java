package domain;

import domain.CompteEpargne;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompteMineur
 *
 */
@Entity

@NamedQuery(name="findAllMineur",query="select a from CompteMineur a")
public class CompteMineur extends CompteEpargne implements Serializable {

	private int cinRepresentantLegal;
	private static final long serialVersionUID = 1L;

	public CompteMineur() {
		super();
	}

	public int getCinRepresentantLegal() {
		return this.cinRepresentantLegal;
	}

	public void setCinRepresentantLegal(int cinRepresentantLegal) {
		this.cinRepresentantLegal = cinRepresentantLegal;
	}

	public CompteMineur(int cinRepresentantLegal) {
		super();
		this.cinRepresentantLegal = cinRepresentantLegal;
	}

}
