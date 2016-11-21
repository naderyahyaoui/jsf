package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Administrateur extends AgentBancaire implements Serializable {

	
	private double primAdmin;
	@OneToMany(mappedBy="admin")
	private List<Materiels> materiels;
	
	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}   
	public double getPrimAdmin() {
		return this.primAdmin;
	}

	public void setPrimAdmin(double primAdmin) {
		this.primAdmin = primAdmin;
	}
	public Administrateur(String login,
			String password) {
		super(login, password);
		
	}
}
