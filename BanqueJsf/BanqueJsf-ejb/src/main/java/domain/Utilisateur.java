package domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="findAllUser",query="select a from Utilisateur a")
@XmlRootElement
public class Utilisateur implements Serializable {

	   





	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int idUser;
	private String firstName;
	private String lastName;
	private String Adress;
	private String tel;
	private String mail;
	private String login;
	private String password;
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	} 
	
		

	public Utilisateur(String firstName, String lastName, String adress, String tel,
			String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Adress = adress;
		this.tel = tel;
		this.mail = mail;
	}
	public Utilisateur(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		
	}

    
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getAdress() {
		return this.Adress;
	}

	public void setAdress(String Adress) {
		this.Adress = Adress;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}   
	   
}
