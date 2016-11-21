package domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Virement
 *
 */
@Entity

@NamedQuery(name="findAll",query="select a from Virement a")
public class Virement implements Serializable {

	@Id
	private int id;
	private int fromCompteRib;
	private int toCompteRib;
	private int solde;
	private String devise;
	private static final long serialVersionUID = 1L;

	public Virement() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getFromCompteRib() {
		return this.fromCompteRib;
	}

	public void setFromCompteRib(int fromCompteRib) {
		this.fromCompteRib = fromCompteRib;
	}   
	public int getToCompteRib() {
		return this.toCompteRib;
	}

	public void setToCompteRib(int toCompteRib) {
		this.toCompteRib = toCompteRib;
	}   
	public int getSolde() {
		return this.solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}   
	public String getDevise() {
		return this.devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}
   
}
