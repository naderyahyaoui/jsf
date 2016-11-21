package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Financier extends AgentBancaire implements Serializable{
	public Financier() {
			
	}
	
	public Financier(String login,
			String password) {
		super(login, password);	
	}
}
