package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AgentBancaire
 *
 */
@Entity

public class AgentBancaire extends Utilisateur implements Serializable {

	   
	
	private double salaire;
	private String grade;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="agent")
	private List<TauxDeChange> taux;
	@OneToMany(mappedBy="agent")
	private List<Budgetisation> budgetisations;
	public AgentBancaire() {
		super();
	}   
		public AgentBancaire(String firstName, String lastName, String adress, String tel,
				String mail,String login, String password, double salaire,
			String grade) {
		super(firstName,  lastName,  adress, tel,
				 mail);
		
		this.salaire = salaire;
		this.grade = grade;
	}

	 
		public String getGrade() {
		return this.grade;
	}

	public double getSalaire() {
			return salaire;
		}
		public void setSalaire(double salaire) {
			this.salaire = salaire;
		}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public AgentBancaire(String login,
			String password) {
		super(login, password);
		
	}
}
